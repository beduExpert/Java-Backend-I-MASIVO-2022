package org.bedu.java.backend.sesion3;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CalculadoraSumaTest.class, CalculadoraRestaTest.class, CalculadoraMultiplicaTest.class, CalculadoraDivideTest.class})
class CalculadoraTest {

}