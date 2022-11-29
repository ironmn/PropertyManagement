package util;

import java.time.LocalDateTime;

public class Logger {
    public static void INFO(String info){
        System.out.println("[INFO]:"+info+"---time："+ LocalDateTime.now() + "---");
    }

    public static void DEBUG(Object obj){
        System.out.println("[DEBUG]:"+obj.toString()+"---time:"+LocalDateTime.now()+ "---");
    }

    public static void ERROR(String message){
        System.out.println("[ERROR]:message:"+message+"---time:"+LocalDateTime.now()+ "---");
    }

}
