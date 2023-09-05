package com.example.awslambda.api;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.example.awslambda.api.model.Product;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//com.example.awslambda.api.ProductLambdaHandler::handleRequest

import java.io.*;

public class ProductLambdaHandler implements RequestStreamHandler {
    private static final String DYNAMO_TABLE = "Products";
    /**
     *  inputStream :include all the incoming data. for example: pathparameters,request body
     *  outputStream: is where we send/write the result, in this example we send the data to API gateway.
     *  context: provides methods and properties that provide info about the invocation, function
     *
     */
   @SuppressWarnings("unchecked") //?
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        JSONParser parser = new JSONParser(); //this will help us parse the request object
        JSONObject responseObject = new JSONObject();// we will add to this object for our api response
        JSONObject responseBody = new JSONObject(); //we will add item to this object

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDB dynamoDB = new DynamoDB(client);

        int id;
        Item resItem = null;

        JSONObject reqObject = null;
        try {
            reqObject = (JSONObject) parser.parse(reader);
            if(reqObject.get("pathParameters") != null){
                JSONObject pps = (JSONObject) reqObject.get("pathParameters");
                if(pps.get("id") != null){
                    id = Integer.parseInt(String.valueOf(pps.get("id")));
                    resItem = dynamoDB.getTable(DYNAMO_TABLE).getItem("id",id);

                }

            }
            if(resItem != null){

                Product product = new Product(resItem.toJSON());
                responseBody.put("product",product);
                responseObject.put("statusCode",200);

            }
            responseObject.put("body",responseBody.toString() );


        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        writer.write(responseObject.toString());
        reader.close();
        writer.close();





    }
}
