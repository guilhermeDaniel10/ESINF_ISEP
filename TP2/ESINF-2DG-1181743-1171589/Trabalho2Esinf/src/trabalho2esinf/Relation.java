    
package trabalho2esinf;

import java.util.Objects;


public class Relation {
    /**
     * User 1
     */
    private User u1;
    /**
     * User 2
     */
    private User u2;
    
    /**
     * Construtor da classe Relation que representa a relação entre dois users
     * @param u1 User 1
     * @param u2 User 2
     */
    public Relation(User u1, User u2) {
        this.u1 = u1;
        this.u2 = u2;
    }

    /**
     * Devolve o User 1
     * @return user 1
     */
    public User getU1() {
        return u1;
    }

    /**
     * Devolve o User 2
     * @return user 2
     */
    public User getU2() {
        return u2;
    }

    /**
     * Modifica o valor do User 1
     * @param u1 user 1 a ser modificado
     */
    public void setU1(User u1) {
        this.u1 = u1;
    }

    /**
     * Modifica o valor do User 2
     * @param u2 user 2 a ser modificado
     */
    public void setU2(User u2) {
        this.u2 = u2;
    }

    /**
     * Método equals a classe Relations
     * @param obj objeto a ser comparado
     * @return true se for igual, false se não for
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Relation other = (Relation) obj;
        if (!Objects.equals(this.u1, other.u1)) {
            return false;
        }
        if (!Objects.equals(this.u2, other.u2)) {
            return false;
        }
        return true;
    }

    /**
     * Devolve a String da classe Relation
     * @return 
     */
    @Override
    public String toString() {
        return "Relation{" + "u1=" + u1 + ", u2=" + u2 + '}';
    }
    
    
    
}
