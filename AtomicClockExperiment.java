package java7;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AtomicClockExperiment {
    public static void main(String[] args) {
        String timeOnEarth = "地表原子钟测得的时间：t=1000s";
        String timeInOrbit = "近地轨道原子钟测得的时间：t=999.5s";

        // 使用正则表达式提取时间数据
        Pattern pattern = Pattern.compile("t=([0-9.]+)s");
        Matcher matcher1 = pattern.matcher(timeOnEarth);
        Matcher matcher2 = pattern.matcher(timeInOrbit);

        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();

        // 如果找到匹配，提取时间数据
        if (matcher1.find()) {
            matcher1.appendReplacement(result1, "$1");
            System.out.println("地表原子钟测得的时间为：" + result1.toString() + "秒");
        }

        if (matcher2.find()) {
            matcher2.appendReplacement(result2, "$1");
            System.out.println("近地轨道原子钟测得的时间为：" + result2.toString() + "秒");
        }

        // 计算时间差
        double timeOnEarthSeconds = Double.parseDouble(result1.toString());
        double timeInOrbitSeconds = Double.parseDouble(result2.toString());
        double timeDifference = timeOnEarthSeconds - timeInOrbitSeconds;

        System.out.println("时间差为：" + timeDifference + "秒");
    }
}