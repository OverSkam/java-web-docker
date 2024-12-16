package trying_web;

public class SimpleUser {
        String name;
        String surname;
        int id;

        public SimpleUser(String name, String surname, int id){
            this.name = name; this.surname = surname; this.id = id;
        }

        public String getName() { return name; }
        public String getSurname() { return surname; }
        public int getId() { return id; }
}
