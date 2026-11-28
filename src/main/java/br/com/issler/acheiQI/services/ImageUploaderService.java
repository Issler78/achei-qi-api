package br.com.issler.acheiQI.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageUploaderService {
    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.service-key}")
    private String serviceKey;

    @Value("${supabase.bucket-name}")
    private String bucket;

    private final RestClient restClient = RestClient.create();

    public String uploadImage(String imageBase64) {
        // if image are in base64 format with prefix "data:image/jpeg;base64," or "data:image/png;base64,", remove all before the comma
        String newImageBase64 = imageBase64.contains(",")
                ? imageBase64.split(",")[1]
                : imageBase64;

        // get bytes of image
        byte[] imageBytes = Base64.getMimeDecoder().decode(newImageBase64);



        String fileName = UUID.randomUUID() + ".jpg";

        // url of image
        String uploadUrl = String.format("%s/storage/v1/object/%s/%s", supabaseUrl, bucket, fileName);

        // send image to supabase
        restClient.post()
                .uri(uploadUrl)
                .header("Authorization", "Bearer " + serviceKey)
                .header("apikey", serviceKey)
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes)
                .retrieve()
                .toBodilessEntity();



        // return PUBLIC url of image
        return String.format("%s/storage/v1/object/public/%s/%s", supabaseUrl, bucket, fileName);
    }
}
