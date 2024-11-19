package aaa;

import java.util.ArrayList;

// 健康专业人员的基类，表示所有类型的医生或健康相关专业人员
// 我使用这个基类封装共有属性和行为，为后续的子类扩展提供基础。
// I used this base class to encapsulate common attributes and behaviors, providing a foundation for subclasses.
class HealthProfessional {
    private final int id;  // 每个健康专业人员的唯一标识符
    private final String name;  // 健康专业人员的姓名
    private final String specialization;  // 健康专业人员的专业领域

    // 默认构造函数，用于创建一个默认的健康专业人员对象
    // 我提供默认值作为占位内容，方便创建未初始化的对象。
    // I provided default values as placeholders to facilitate the creation of uninitialized objects.
    public HealthProfessional() {
        this.id = 0;  // 默认 ID
        this.name = "Unknown";  // 默认姓名
        this.specialization = "Unknown";  // 默认专业领域
    }

    // 全参数构造函数，用于创建一个特定的健康专业人员对象
    // 我使用这个构造函数允许直接传递具体信息，确保对象的初始化完整性。
    // I used this constructor to allow passing specific information directly, ensuring object initialization completeness.
    public HealthProfessional(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // 打印健康专业人员的详细信息
    // 我设计该方法用于统一输出健康专业人员的基本信息。
    // I designed this method to standardize the output of basic health professional information.
    public void printDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization);
    }

    // 打印健康专业人员的类型
    // 这是一个虚方法，允许子类通过覆盖实现多态。
    // This is a virtual method that allows subclasses to override it, demonstrating polymorphism.
    public void printProfessionalType() {
        System.out.println("Health Professional");
    }
}

// GeneralPractitioner 类是 HealthProfessional 的子类，表示全科医生
// 我使用该子类添加全科医生特有的属性，例如 gpType，区分其独特性。
// I used this subclass to add attributes specific to general practitioners, such as gpType, to distinguish its uniqueness.
class GeneralPractitioner extends HealthProfessional {
    private final String gpType;  // 表示全科医生的类型，例如“初级保健医生”

    // 默认构造函数，用于创建一个默认的全科医生对象
    // 提供默认类型 "General" 以便快速创建通用对象。
    // Provides a default type "General" for quickly creating general objects.
    public GeneralPractitioner() {
        super();  // 调用父类的默认构造函数
        this.gpType = "General";  // 默认类型
    }

    // 全参数构造函数，用于创建一个特定的全科医生对象
    // 通过该构造函数，父类通用属性和子类特有属性可以同时初始化。
    // Through this constructor, both parent class general attributes and subclass-specific attributes can be initialized simultaneously.
    public GeneralPractitioner(int id, String name, String specialization, String gpType) {
        super(id, name, specialization);  // 调用父类的构造函数
        this.gpType = gpType;
    }

    @Override
    public void printDetails() {
        super.printDetails();  // 调用父类的打印方法
        // 我扩展了父类方法以包括 gpType 信息，体现子类的独特性。
        // I extended the parent class method to include gpType information, reflecting the uniqueness of the subclass.
        System.out.println("Type: " + gpType);
    }

    @Override
    public void printProfessionalType() {
        // 我覆盖了父类方法，使得类型输出为“General Practitioner”。
        // I overrode the parent class method to output the type as "General Practitioner."
        System.out.println("General Practitioner");
    }
}

// Specialist 类是 HealthProfessional 的子类，表示专家
// 我将专家的特定领域 specialty 添加为新属性，方便在子类中扩展不同的专家类型。
// I added the specific field specialty as a new attribute to facilitate extending different specialist types in the subclass.
class Specialist extends HealthProfessional {
    private final String specialty;  // 表示专家的具体领域，例如“心脏病学”

    // 默认构造函数，用于创建一个默认的专家对象
    // 默认值 "Unknown Specialty" 提供快速创建占位对象的能力。
    // Default value "Unknown Specialty" provides the ability to quickly create placeholder objects.
    public Specialist() {
        super();  // 调用父类的默认构造函数
        this.specialty = "Unknown Specialty";  // 默认领域
    }

    // 全参数构造函数，用于创建一个特定的专家对象
    // 通过该构造函数传递所有必要的信息，确保对象初始化的完整性。
    // This constructor passes all necessary information to ensure the completeness of object initialization.
    public Specialist(int id, String name, String specialization, String specialty) {
        super(id, name, specialization);  // 调用父类的构造函数
        this.specialty = specialty;
    }

    @Override
    public void printDetails() {
        super.printDetails();  // 调用父类的打印方法
        // 我扩展了打印功能以输出 specialty 字段，明确显示专家的领域。
        // I extended the printing functionality to output the specialty field, clearly indicating the specialist's field.
        System.out.println("Specialty: " + specialty);
    }

    @Override
    public void printProfessionalType() {
        // 我覆盖了父类方法，使得类型输出为“Specialist”。
        // I overrode the parent class method to output the type as "Specialist."
        System.out.println("Specialist");
    }
}

// Appointment 类表示患者的预约信息
// 我设计该类用于封装患者和健康专业人员之间的预约详情。
// I designed this class to encapsulate appointment details between patients and health professionals.
class Appointment {
    private String patientName;  // 患者姓名
    private final String mobile;  // 患者手机号，唯一标识
    private final String timeSlot;  // 预约的时间段
    private final HealthProfessional healthProfessional;  // 对应的健康专业人员

    // 构造函数，用于创建一个预约对象
    // 我通过该构造函数确保所有必要的预约信息在对象创建时就已提供。
    // This constructor ensures all necessary appointment information is provided at the time of object creation.
    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional healthProfessional) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.healthProfessional = healthProfessional;
    }

    // 打印预约的详细信息
    // 我设计了 printDetails 方法以输出完整的预约信息，包括医生详情。
    // I designed the printDetails method to output complete appointment information, including doctor details.
    public void printDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Mobile: " + mobile);
        System.out.println("Time Slot: " + timeSlot);
        healthProfessional.printDetails();  // 调用医生的打印方法
        System.out.println("------------------------------");
    }

    // 获取患者手机号（用于查找或取消预约）
    // 我通过该方法提供对患者手机号的只读访问，确保符合封装原则。
    // This method provides read-only access to the patient's mobile number, adhering to encapsulation principles.
    public String getMobile() {
        return mobile;
    }

    // 获取患者姓名
    // 提供对患者姓名的只读访问。
    // Provides read-only access to the patient's name.
    public String getPatientName() {
        return patientName;
    }

    // 修改患者姓名
    // 我提供 setPatientName 方法以允许动态更新预约中的患者姓名。
    // I provided the setPatientName method to allow dynamic updates to the patient's name in the appointment.
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}

// AppointmentManager 类管理所有预约
// 该类通过 ArrayList 存储和管理多个预约，提供添加、打印和取消预约的功能。
// This class manages all appointments using an ArrayList and provides functionality to add, print, and cancel appointments.
class AppointmentManager {
    private final ArrayList<Appointment> appointments;  // 存储所有预约的集合
    // I chose ArrayList to store appointments because it allows dynamic resizing and supports efficient addition and iteration.

    // 构造函数，初始化预约列表
    // 初始化时创建一个空的 ArrayList，确保后续操作可以正常执行。
    // The constructor initializes an empty ArrayList to ensure subsequent operations can be executed without issues.
    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    // 添加预约到列表
    // 我设计 addAppointment 方法用于向集合中添加新预约，并输出确认信息，确保用户能看到添加结果。
    // I designed the addAppointment method to add new appointments to the list and print a confirmation message to ensure users can see the result.
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);  // 将预约添加到集合中
        // 通过调用 appointment 的 getPatientName 方法，确保符合封装原则访问患者姓名。
        // Access the patient's name using the getPatientName method to adhere to encapsulation principles.
        System.out.println("Appointment added for " + appointment.getPatientName());
    }

    // 打印所有预约信息
    // printExistingAppointments 方法会遍历当前的预约集合，调用每个预约对象的 printDetails 方法打印信息。
    // The printExistingAppointments method iterates through the current appointment list and calls the printDetails method of each appointment object to print details.
    public void printExistingAppointments() {
        if (appointments.isEmpty()) {
            // 当集合为空时提示用户当前无预约信息。
            // Prompt the user when the list is empty to indicate no appointments exist.
            System.out.println("No existing appointments.");
            return;
        }
        for (Appointment appointment : appointments) {
            // 遍历集合并打印预约的详细信息。
            // Iterate through the list and print the details of each appointment.
            appointment.printDetails();
        }
    }

    // 根据手机号取消预约
    // cancelAppointment 方法通过匹配手机号查找并移除对应的预约。
    // The cancelAppointment method searches for and removes the corresponding appointment by matching the mobile number.
    public void cancelAppointment(String mobile) {
        boolean found = false;  // 标志变量，表示是否找到匹配的预约
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getMobile().equals(mobile)) {
                // 当手机号匹配时，移除对应的预约并打印提示信息。
                // When the mobile number matches, remove the corresponding appointment and print a prompt.
                appointments.remove(i);
                System.out.println("Appointment canceled for mobile: " + mobile);
                found = true;  // 更新标志变量，表示预约已找到
                break;
            }
        }
        if (!found) {
            // 如果未找到匹配的预约，提示用户。
            // Prompt the user if no matching appointment is found.
            System.out.println("No appointment found for mobile: " + mobile);
        }
    }
}

// 主类 test2，用于测试功能
// 我使用主类的 main 方法测试前述类的功能，包括创建对象、添加预约、打印预约及取消预约。
// The main method of the test2 class is used to test the functionality of the aforementioned classes, including object creation, adding appointments, printing appointments, and canceling appointments.
public class OOPA1 {
    public static void main(String[] args) {
        // 创建健康专业人员对象
        // 我通过创建多个不同类型的健康专业人员对象测试继承和多态功能。
        // I tested inheritance and polymorphism by creating multiple health professional objects of different types.
        HealthProfessional gp1 = new GeneralPractitioner(1, "Dr. John", "General Medicine", "Primary Care");
        HealthProfessional gp2 = new GeneralPractitioner(2, "Dr. Smith", "Family Medicine", "Primary Care");
        HealthProfessional gp3 = new GeneralPractitioner(3, "Dr. Wilson", "Pediatrics", "Primary Care");
        HealthProfessional sp1 = new Specialist(4, "Dr. Brown", "Cardiology", "Cardiologist");
        HealthProfessional sp2 = new Specialist(5, "Dr. Green", "Dermatology", "Dermatologist");

        // 打印健康专业人员信息
        // 调用 printProfessionalType 和 printDetails 方法打印每个健康专业人员的信息。
        // Calls the printProfessionalType and printDetails methods to print information about each health professional.
        System.out.println("Health Professionals:");
        gp1.printProfessionalType();
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printProfessionalType();
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printProfessionalType();
        gp3.printDetails();
        System.out.println("------------------------------");
        sp1.printProfessionalType();
        sp1.printDetails();
        System.out.println("------------------------------");
        sp2.printProfessionalType();
        sp2.printDetails();

        // 创建 AppointmentManager 实例
        // 实例化 AppointmentManager 以管理预约，并对其方法进行测试。
        // Instantiate AppointmentManager to manage appointments and test its methods.
        AppointmentManager manager = new AppointmentManager();

        // 添加预约到系统中
        // 添加多个预约对象以测试 addAppointment 方法的正确性。
        // Add multiple appointment objects to test the correctness of the addAppointment method.
        manager.addAppointment(new Appointment("Alice", "1234567890", "10:00", gp1));
        manager.addAppointment(new Appointment("Bob", "0987654321", "14:00", sp1));
        manager.addAppointment(new Appointment("Charlie", "1122334455", "09:00", gp2));
        manager.addAppointment(new Appointment("Diana", "5566778899", "11:30", sp2));

        // 打印现有的预约
        // 调用 printExistingAppointments 方法打印当前所有的预约记录。
        // Call the printExistingAppointments method to print all current appointment records.
        System.out.println("\nExisting appointments:");
        manager.printExistingAppointments();

        // 根据手机号取消预约
        // 通过手机号“1234567890”取消预约，测试 cancelAppointment 方法是否正确执行。
        // Cancel an appointment using the mobile number "1234567890" to test if the cancelAppointment method executes correctly.
        manager.cancelAppointment("1234567890");

        // 打印更新后的预约
        // 再次调用 printExistingAppointments 方法确认预约记录是否已更新。
        // Call the printExistingAppointments method again to confirm if the appointment records have been updated.
        System.out.println("\nUpdated appointments:");
        manager.printExistingAppointments();
    }
}



