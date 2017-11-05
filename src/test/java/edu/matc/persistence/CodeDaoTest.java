package edu.matc.persistence;

import edu.matc.entity.Code;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class CodeDaoTest {

    @Test
    public void getClientByDescription() throws Exception {
        String searchTerm = "Client";
        CodeDao codeDao = new CodeDao();
        List<Code> codes = codeDao.getCodeByDescription(searchTerm);
        assertEquals("Wrong number of client bill codes", 11, codes.size());
    }

}