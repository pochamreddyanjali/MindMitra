package com.mindmitra.backend.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.*;

@Service
public class GeminiService {

    // =========================
    // OPENROUTER API KEY
    // =========================

    @Value("${openrouter.api.key}")
    private String apiKey;

    // =========================
    // OKHTTP CLIENT
    // =========================

    private final OkHttpClient client =
            new OkHttpClient();

    // =========================
    // GET AI RESPONSE
    // =========================

    public String getResponse(
            String userMessage) {

        try {

            // =========================
            // OPENROUTER URL
            // =========================

            String url =
                    "https://openrouter.ai/api/v1/chat/completions";

            // =========================
            // USER MESSAGE
            // =========================

            JSONObject messageObject =
                    new JSONObject();

            messageObject.put(
                    "role",
                    "user"
            );

            messageObject.put(
                    "content",

                    "You are MindMitra AI, a calm and supportive mental wellness assistant. " +

                    "Help users with emotional support, motivation, positivity and stress relief.\n\n"

                    +

                    userMessage
            );

            JSONArray messagesArray =
                    new JSONArray();

            messagesArray.put(
                    messageObject
            );

            // =========================
            // REQUEST JSON
            // =========================

            JSONObject requestJson =
                    new JSONObject();

            requestJson.put(
                    "model",
                    "openai/gpt-3.5-turbo"
            
            );

            requestJson.put(
                    "messages",
                    messagesArray
            );

            // =========================
            // REQUEST BODY
            // =========================

            RequestBody body =
                    RequestBody.create(

                            requestJson.toString(),

                            MediaType.parse(
                                    "application/json"
                            )

                    );

            // =========================
            // REQUEST
            // =========================

            Request request =
                    new Request.Builder()

                            .url(url)

                            .post(body)

                            .addHeader(
                                    "Authorization",

                                    "Bearer " + apiKey
                            )

                            .addHeader(
                                    "Content-Type",

                                    "application/json"
                            )

                            .build();

            // =========================
            // RESPONSE
            // =========================

            Response response =
                    client.newCall(request)
                            .execute();

            String responseBody =
                    response.body().string();

            System.out.println(responseBody);

            JSONObject jsonResponse =
                    new JSONObject(
                            responseBody
                    );

            JSONArray choices =
                    jsonResponse.getJSONArray(
                            "choices"
                    );

            JSONObject firstChoice =
                    choices.getJSONObject(0);

            JSONObject message =
                    firstChoice.getJSONObject(
                            "message"
                    );

            return message.getString(
                    "content"
            );

        }

        catch (Exception e) {

            e.printStackTrace();

            return "MindMitra AI is currently unavailable.";

        }

    }

}

