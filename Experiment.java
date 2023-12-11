package java7;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Experiment {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 建立实验器材库存列表
        Equipment[] equipments = new Equipment[] {
                new Equipment("Model-01", "E001", 5, "2020-01-01", "M01-001", "Alice"),
                new Equipment("Model-02", "E002", 2, "2020-02-01", "M02-001", "Bob"),
                new Equipment("Model-03", "E003", 3, "2020-03-01", "M03-001", "Charlie")
        };

        while (true) {
            System.out.println("请输入您要查询的实验仪器型号：");
            String model = scanner.nextLine();

            // 搜索实验器材库存列表，找到与用户输入的型号匹配的器材
            Equipment equipment = null;
            for (Equipment e : equipments) {
                if (e.model.equals(model)) {
                    equipment = e;
                    break;
                }
            }

            // 如果没有找到则提示用户输入有误
            if (equipment == null) {
                System.out.println("没有找到符合条件的实验仪器，请重新输入！");
                continue;
            }

            // 输出该实验仪器的详细信息
            System.out.println("编号：" + equipment.id);
            System.out.println("数量：" + equipment.quantity);
            System.out.println("出厂日期：" + equipment.manufactureDate);
            System.out.println("指导手册编号：" + equipment.manualId);
            System.out.println("维护员姓名：" + equipment.maintainer);

            System.out.println("请输入实验室名称：");
            String labName = scanner.nextLine();

            System.out.println("请输入学生姓名：");
            String studentName = scanner.nextLine();

            System.out.println("请输入实验开始时间（格式为 yyyy-MM-dd HH:mm）：");
            String startTimeString = scanner.nextLine();
            Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})");
            Matcher matcher = pattern.matcher(startTimeString);
            if (!matcher.matches()) {
                System.out.println("输入的时间格式有误，请重新输入！");
                continue;
            }
            long startTime = Long.parseLong(startTimeString.replace("-", "").replace(" ", "").replace(":", ""));

            System.out.println("请输入实验结束时间（格式为 yyyy-MM-dd HH:mm）：");
            String endTimeString = scanner.nextLine();
            matcher = pattern.matcher(endTimeString);
            if (!matcher.matches()) {
                System.out.println("输入的时间格式有误，请重新输入！");
                continue;
            }
            long endTime = Long.parseLong(endTimeString.replace("-", "").replace(" ", "").replace(":", ""));

            System.out.println("请输入实验名称：");
            String experimentName = scanner.nextLine();

            System.out.println("学生 " + studentName + " 在 " + labName +
                    " 实验室，于 " + startTimeString + " 开始至 " + endTimeString +
                    " 结束，使用 " + model + " 实验仪器，进行了 " + experimentName + " 实验。");
            break;
        }
    }

}

class Equipment {
    String model;
    String id;
    int quantity;
    String manufactureDate;
    String manualId;
    String maintainer;

    public Equipment(String model, String id, int quantity,
                     String manufactureDate, String manualId, String maintainer) {
        this.model = model;
        this.id = id;
        this.quantity = quantity;
        this.manufactureDate = manufactureDate;
        this.manualId = manualId;
        this.maintainer = maintainer;
    }
}
