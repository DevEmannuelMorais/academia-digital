package ml.academiadigital.exception;

public class AlunoNotFoundException extends RuntimeException{
    public AlunoNotFoundException(long id) {
        super("Could not find the id: "+ id);
    }


}
