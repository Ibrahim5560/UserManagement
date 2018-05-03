package mena;

import mena.model.Line;
import mena.service.LineService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
public class LineTester {

    private Client client;
    private String REST_SERVICE_URL = "http://localhost:9090/LineResource/lines";
    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    private void init()
    {
        this.client = ClientBuilder.newClient();
    }

    public static void main(String[] args)
    {
        LineTester tester = new LineTester();
        //initialize the tester
        tester.init();
        //test get all papers Web Service Method
        tester.testGetAllPapers();
        //test get paper Web Service Method
        tester.testGetPaper();
        //test update paper Web Service Method
        tester.testUpdatePaper();
        //test add paper Web Service Method
        tester.testAddPaper();
        //test delete paper Web Service Method
        tester.testDeletePaper();
    }
    //Test: Get list of all papers
    //Test: Check if list is not empty
    private void testGetAllPapers()
    {
        GenericType<List<Line>> list = new GenericType<List<Line>>() {};
        List<Line> paper = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_JSON)
                .get(list);
        String result = PASS;
        if(paper.isEmpty())
        {
            result = FAIL;
        }
        System.out.println("Test case name: testGetAllPapers, Result: " + result );
    }
    //Test: Get Paper of id 1
    //Test: Check if new is same as sample new
    private void testGetPaper()
    {
        Line samplePaper = new Line();
        samplePaper.setId(1);
        Line paper = client.target(REST_SERVICE_URL).path("/{paperid}").resolveTemplate("paperid", 1).request(MediaType.APPLICATION_JSON)
                .get(Line.class);
        String result = FAIL;
        if(samplePaper != null && samplePaper.getId() == paper.getId()){
            result = PASS;
        }
        System.out.println("Test case name: testGetPaper, Result: " + result );
    }
    //Test: Update Paper of id 2
    //Test: Check if result is success Json.
    private void testUpdatePaper(){
        //------------------------------------------
        Line paper = new Line(2,new Timestamp (System.currentTimeMillis()), "Shaker" ,"Clerk","Management Department");
        LineService paperService = new LineService();
        //------------------------------------------
        String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(paper, MediaType.APPLICATION_JSON),String.class);
        String result = FAIL;
        if(paperService.updatePaper(paper) == 1){
            result = PASS;
        }
        System.out.println("Test case name: testUpdatePaper, Result: " + result );
        System.out.println(callResult);
    }
    //Test: Add Paper of id 3
    //Test: Check if result is success Json.
    private void testAddPaper(){
        //------------------------------------------
        Line paper = new Line(3, new Timestamp(System.currentTimeMillis()), "Hatem" ,"Project Manager","Management Department");
        //------------------------------------------
        String callResult = client.target(REST_SERVICE_URL).request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(paper,MediaType.APPLICATION_JSON),String.class);
        String result = FAIL;
        if(!callResult.isEmpty())
        {
            result = PASS;
        }
        System.out.println("Test case name: testAddPaper, Result: " + result );
        System.out.println(callResult);
    }
    //Test: Delete Paper of id 3
    //Test: Check if result is success Json.
    private void testDeletePaper()
    {
        //------------------------------------------
        LineService paperService = new LineService();
        //------------------------------------------
        String callResult = client.target(REST_SERVICE_URL).path("/{paperid}").resolveTemplate("paperid",3).request(MediaType.APPLICATION_JSON)
                .delete(String.class);
        String result = FAIL;
        if(callResult.equals("success"))
        {
            paperService.deletePaper(3);
            result = PASS;
        }
        System.out.println("Test case name: testDeletePaper, Result: " + result );
    }
}