package properties.general;

import com.claudio.school.dtos.IdentificatorDTO;

public class GeneralInstance extends GeneralProperties{
    public static IdentificatorDTO instaceIdentificatorDTO() {
        return new IdentificatorDTO(ID);
    }
}
