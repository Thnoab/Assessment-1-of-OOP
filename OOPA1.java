package aaa;

import java.util.ArrayList;

// 基类 HealthProfessional
class HealthProfessional {
    private final int id;  // 健康专业人员的唯一标识
    private final String name;  // 健康专业人员的姓名
    private final String specialization;  // 健康专业人员的专业领域

    // 构造函数，初始化健康专业人员的信息
    public HealthProfessional(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // 打印健康专业人员的基本信息
    public void printDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }

    // 打印健康专业人员的类型，子类可以重写该方法
    public void printProfessionalType() {
        System.out.println("Health Professional");
    }
}

// GeneralPractitioner 类，继承自 HealthProfessional
class GeneralPractitioner extends HealthProfessional {
    private final String gpType;  // 全科医生的类型

    public GeneralPractitioner(int id, String name, String specialization, String gpType) {
        super(id, name, specialization);  // 调用父类构造函数初始化
        this.gpType = gpType;
    }

    @Override
    public void printDetails() {
        super.printDetails();  // 调用父类的 printDetails 方法
        System.out.println("Type: " + gpType);
    }

    @Override
    public void printProfessionalType() {
        System.out.println("General Practitioner");
    }
}

// Specialist 类，继承自 HealthProfessional
class Specialist extends HealthProfessional {
    private final String specialty;  // 专家领域

    public Specialist(int id, String name, String specialization, String specialty) {
        super(id, name, specialization);  // 调用父类构造函数初始化
        this.specialty = specialty;
    }

    @Override
    public void printDetails() {
        super.printDetails();  // 调用父类的 printDetails 方法
        System.out.println("Specialty: " + specialty);
    }

    @Override
    public void printProfessionalType() {
        System.out.println("Specialist");
    }
}

// Appointment 类，用于存储预约信息
class Appointment {
    private String patientName;  // 患者姓名
    private final String mobile;  // 患者手机号
    private final String timeSlot;  // 预约时间
    private final HealthProfessional healthProfessional;  // 健康专业人员

    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional healthProfessional) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.healthProfessional = healthProfessional;
    }

    // 打印预约信息
    public void printDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Mobile: " + mobile);
        System.out.println("Time Slot: " + timeSlot);
        healthProfessional.printDetails();  // 调用健康专业人员的打印方法
        System.out.println("------------------------------");
    }

    // 获取患者手机号
    public String getMobile() {
        return mobile;
    }

    // 获取和设置患者姓名
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}

// AppointmentManager 类，用于管理所有预约
class AppointmentManager {
    private final ArrayList<Appointment> appointments;  // 存储预约的列表

    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    // 添加预约
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added for " + appointment.getPatientName());
    }

    // 打印所有预约信息
    public void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }
        for (Appointment appointment : appointments) {
            appointment.printDetails();
        }
    }

    // 取消预约
    public void cancelAppointment(String mobile) {
        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getMobile().equals(mobile)) {
                appointments.remove(i);
                System.out.println("Appointment canceled for mobile: " + mobile);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No appointment found for mobile: " + mobile);
        }
    }
}

// 主类 OOPA1，用于测试
public class OOPA1 {
    public static void main(String[] args) {
        // 创建健康专业人员对象
        HealthProfessional gp1 = new GeneralPractitioner(1, "Dr. John", "General Medicine", "Primary Care");
        HealthProfessional gp2 = new GeneralPractitioner(2, "Dr. Smith", "Family Medicine", "Primary Care");
        HealthProfessional sp1 = new Specialist(3, "Dr. Brown", "Cardiology", "Cardiologist");
        HealthProfessional sp2 = new Specialist(4, "Dr. Green", "Dermatology", "Dermatologist");

        // 打印所有健康专业人员信息
        System.out.println("Health Professionals:");
        gp1.printProfessionalType();
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printProfessionalType();
        gp2.printDetails();
        System.out.println("------------------------------");
        sp1.printProfessionalType();
        sp1.printDetails();
        System.out.println("------------------------------");
        sp2.printProfessionalType();
        sp2.printDetails();

        // 创建 AppointmentManager 实例
        AppointmentManager manager = new AppointmentManager();

        // 添加预约
        manager.addAppointment(new Appointment("Alice", "1234567890", "10:00", gp1));
        manager.addAppointment(new Appointment("Bob", "0987654321", "14:00", sp1));
        manager.addAppointment(new Appointment("Charlie", "1122334455", "09:00", gp2));
        manager.addAppointment(new Appointment("Diana", "5566778899", "11:30", sp2));

        // 打印现有预约
        System.out.println("\nExisting appointments:");
        manager.printExistingAppointments();

        // 取消预约
        manager.cancelAppointment("1234567890");

        // 再次打印预约
        System.out.println("\nUpdated appointments:");
        manager.printExistingAppointments();
    }
}
