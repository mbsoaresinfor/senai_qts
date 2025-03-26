package aula;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({RepositorioListaPessoaTest.class, 
	CalculadoraTest.class})
public class SuiteTests {

}
