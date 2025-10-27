package org.cdlg.aiwenzizhuanyuyinalbb.Controller;

import com.alibaba.cloud.ai.dashscope.api.DashScopeSpeechSynthesisApi;
import com.alibaba.cloud.ai.dashscope.audio.DashScopeSpeechSynthesisOptions;
import com.alibaba.cloud.ai.dashscope.audio.synthesis.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@RestController
public class TTSController {

    private static final String TEXT =  "八百标兵奔北坡，炮兵并排北边跑，炮兵怕把标兵碰，标兵怕碰炮兵炮。";
    private static final String FILE_PATH = "src/main/resources/tts";

    @Autowired
    private SpeechSynthesisModel speechSynthesisModel;

    @GetMapping("/tts")
    public void textToSpeech() {
        DashScopeSpeechSynthesisOptions synthesisOptions = DashScopeSpeechSynthesisOptions.builder()
                .withResponseFormat(DashScopeSpeechSynthesisApi.ResponseFormat.MP3)
                .withSpeed(0.8).build();
        SpeechSynthesisResponse synthesisResponse = speechSynthesisModel.call(new SpeechSynthesisPrompt(TEXT, synthesisOptions));
        SpeechSynthesisResult responseResult = synthesisResponse.getResult();
        SpeechSynthesisOutput synthesisOutput = responseResult.getOutput();

        ByteBuffer audio = synthesisOutput.getAudio();

        File file = new File(FILE_PATH + "/output.mp3");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(audio.array());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

