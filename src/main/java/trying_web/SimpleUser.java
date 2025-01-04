package trying_web;

public class SimpleUser {
        String name;
        String surname;
        int id;
        String image;

        public SimpleUser(String name, String surname, int id, String image){
            this.name = name; this.surname = surname; this.id = id; this.image = image;
        }

        public String getName() { return name; }
        public String getSurname() { return surname; }
        public int getId() { return id; }
        public String getImage() { return image; }
}
