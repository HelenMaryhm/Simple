package org.example.openaijava;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;

import java.util.List;

public class openAiJavaMain {

    // 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
    /*
    https://platform.openai.com/docs/api-reference/introduction
    https://platform.openai.com/docs/overview
    https://platform.openai.com/docs/libraries/python-library
    https://github.com/TheoKanning/openai-java
    https://www.udemy.com/course/bootcamp-generative-artificial-intelligence-and-llm-app-development/learn/lecture/42087978#overview
     */

    public static void main(String[] args){

        ObjectMapper objectMapper = new ObjectMapper();
        OkHttpClient okHttpClient = new OkHttpClient();

        // https://github.com/TheoKanning/openai-java

        OpenAiService openAiService = new OpenAiService("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");
        CompletionRequest completionRequest = CompletionRequest.builder().prompt("Thank You Jesus").model("babbage-002").echo(true).build();

        CompletionResult completionResult = openAiService.createCompletion(completionRequest);
        List<CompletionChoice> completionChoiceList = completionResult.getChoices();
        completionChoiceList.stream().forEach(System.out::println);

    }

/*
Error
Caused by: retrofit2.adapter.rxjava2.HttpException: HTTP 429
 */


}
