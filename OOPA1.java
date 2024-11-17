package aaa;

import java.util.ArrayList;

// 基类
class HealthProfessional {
    private final int id;
    private final String name;
    private final String specialization;

    // 构造函数，初始化健康专业人员的信息
    public HealthProfessional(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public void printDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }

    public void printProfessionalType() {
        System.out.println("Health Professional");
    }
}

// GeneralPractitioner 类，继承自 HealthProfessional
class GeneralPractitioner extends HealthProfessional {
    private final String gpType;

    public GeneralPractitioner(int id, String name, String specialization, String gpType) {
        super(id, name, specialization);
        this.gpType = gpType;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Type: " + gpType);
    }

    @Override
    public void printProfessionalType() {
        System.out.println("General Practitioner");
    }
}

// Specialist 类，继承自 HealthProfessional
class Specialist extends HealthProfessional {
    private final String specialty;

    public Specialist(int id, String name, String specialization, String specialty) {
        super(id, name, specialization);
        this.specialty = specialty;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Specialty: " + specialty);
    }

    @Override
    public void printProfessionalType() {
        System.out.println("Specialist");
    }
}

// Appointment 类，用于存储预约信息
class Appointment {
    private String patientName;
    private final String mobile;
    private final String timeSlot;
    private final HealthProfessional healthProfessional;

    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional healthProfessional) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.healthProfessional = healthProfessional;
    }

    public void printDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Mobile: " + mobile);
        System.out.println("Time Slot: " + timeSlot);
        healthProfessional.printDetails();
        System.out.println("------------------------------");
    }

    public String getMobile() {
        return mobile;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}

// AppointmentManager 类，用于管理所有预约
class AppointmentManager {
    private final ArrayList<Appointment> appointments;

    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added for " + appointment.getPatientName());
    }

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
        HealthProfessional gp1 = new GeneralPractitioner(1, "Dr. John", "General Medicine", "Primary Care");
        HealthProfessional gp2 = new GeneralPractitioner(2, "Dr. Smith", "Family Medicine", "Primary Care");
        HealthProfessional sp1 = new Specialist(3, "Dr. Brown", "Cardiology", "Cardiologist");
        HealthProfessional sp2 = new Specialist(4, "Dr. Green", "Dermatology", "Dermatologist");

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

        AppointmentManager manager = new AppointmentManager();

        manager.addAppointment(new Appointment("Alice", "1234567890", "10:00", gp1));
        manager.addAppointment(new Appointment("Bob", "0987654321", "14:00", sp1));
        manager.addAppointment(new Appointment("Charlie", "1122334455", "09:00", gp2));
        manager.addAppointment(new Appointment("Diana", "5566778899", "11:30", sp2));

        System.out.println("\nExisting appointments:");
        manager.printExistingAppointments();

        manager.cancelAppointment("1234567890");

        System.out.println("\nUpdated appointments:");
        manager.printExistingAppointments();
    }
}
