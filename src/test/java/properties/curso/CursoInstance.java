package properties.curso;

import com.claudio.school.dtos.curso.CursoPDTO;
import com.claudio.school.dtos.curso.CursoUDTO;
import com.claudio.school.model.Curso;

public class CursoInstance extends CursoProperties {

    public static Curso instace() {
        return Curso.builder().id(ID).nome(NOME).descricao(DESCRICAO).duracao(DURACAO).build();
    }

    public static CursoPDTO instaceCursoPDTO() {
        return new CursoPDTO(NOME, DESCRICAO, DURACAO);
    }

    public static CursoUDTO instaceCursoUDTO() {
        return new CursoUDTO(ID, NOME, DESCRICAO, DURACAO);
    }
}
