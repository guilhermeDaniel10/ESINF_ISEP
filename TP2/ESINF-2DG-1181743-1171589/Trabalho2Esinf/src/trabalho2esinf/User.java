
package trabalho2esinf;

import java.util.Objects;


public class User {
    /**
     * id do utilizador
     */
    private String user;
    /**
     * Idade do utilizador
     */
    private int age;
    /**
     * Cidade do utilizador
     */
    private String city;

    /**
     * Construtor da classe User
     * @param user id do utilizador
     * @param age idade do utilizador
     * @param city cidade do utilizador
     */
    public User(String user, int age, String city) {
        this.user = user;
        this.age = age;
        this.city = city;
    }

    /**
     * Devolve o id do utilizador
     * @return id do utilizador
     */
    public String getUser() {
        return user;
    }

    /**
     * Devolve a idade do utilizador
     * @return idade do utilizador
     */
    public int getAge() {
        return age;
    }

    /**
     * Devolve a cidade do utilizador
     * @return cidade do utilizador
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Modifica o id do utilizador
     * @param user id do utilizador a ser modificado
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Modifica a idade do utilizador
     * @param age idade do utilizador a ser modificada
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Modifica a cidade do utilizaodr
     * @param city cidade do utilizador a ser modificada
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Método equals da classe User
     * @param obj objeto a ser comparado
     * @return true se for igual, false se não for
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null && getClass() != obj.getClass()) {
            return false;
        }

        User o = (User) obj;

        return this.user.contains(o.user)
                && this.age == o.age
                && this.city.contains(o.city);

    }

    /**
     * Devolve o método toString da classe User
     * @return String da classe User
     */
    @Override
    public String toString() {
        return "User{" + "user=" + user + ", age=" + age + ", city=" + city + '}';
    }

}
