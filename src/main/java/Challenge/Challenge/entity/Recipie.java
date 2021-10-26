package Challenge.Challenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recipie {
        @Id
        private int id;
        private String name;
        private String image;
        private String category;
        private String label;
        private double price;
        private String description;

        Recipie(){
                super();
        }

        public Recipie(int id, String name, String image, String category, String label, double price, String description){
                this.id = id;
                this.name = name;
                this.image = image;
                this.category = category;
                this.label = label;
                this.price = price;
                this.description = description;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getLabel() {
                return label;
        }

        public void setLabel(String label) {
                this.label = label;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
