public class EmployeeService{
    public static void main(String[] args){
    
    Employee employee =
            new Employee(101, "Sahasra");
    
    SMSNotification sms = new SMSNotification();
    sms.send(employee);
    
    WhatsAppNotification whatsapp = new WhatsAppNotification();
    whatsapp.send(employee);
    }
}

//Employee Entity
class Employee{
    int id;
    String name;
    
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}

interface sendNotification{
    void send(Employee emp);
}

class SMSNotification implements sendNotification{
    public void send(Employee emp){
        System.out.println("SMS Notification for " + emp.getName());
    }
}

class WhatsAppNotification implements sendNotification{
    public void send(Employee emp){
        System.out.println("WhatsApp Notification for " + emp.getName());
    }
}
