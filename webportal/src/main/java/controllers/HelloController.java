package controllers;


import mechanisms.WordsMechanism;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class HelloController {

    WordsMechanism wordsMechanism;

    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("message", "Hello super Ivan");

        return "hello";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public  String get(ModelMap modelMap){
            return "upload";
        }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {

//        try {
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
//            BufferedReader bufferedReader = new BufferedReader()
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String text = new String (bytes);
                wordsMechanism.countTop10words(text);

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }


}
