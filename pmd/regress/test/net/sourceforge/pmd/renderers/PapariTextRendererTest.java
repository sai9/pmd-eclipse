package test.net.sourceforge.pmd.renderers;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.Report.ProcessingError;
import net.sourceforge.pmd.renderers.AbstractRenderer;
import net.sourceforge.pmd.renderers.PapariTextRenderer;

import java.io.Reader;
import java.io.StringReader;

public class PapariTextRendererTest extends AbstractRendererTst {

    public AbstractRenderer getRenderer() {
        return new PapariTextRenderer(){
            protected Reader getReader(String sourceFile) {
                return new StringReader("public class Foo {}");
            }
        };
    }

    public String getExpected() {
        return "* file: n/a" + PMD.EOL + "    src:  n/a:1:1" + PMD.EOL + "    rule: Foo" + PMD.EOL + "    msg:  msg" + PMD.EOL + "    code: public class Foo {}" + PMD.EOL + PMD.EOL + PMD.EOL + PMD.EOL + "Summary:" + PMD.EOL + PMD.EOL + " : 1" + PMD.EOL + "* warnings: 1" + PMD.EOL;
    }
    
    public String getExpectedEmpty() {
        return PMD.EOL + PMD.EOL + "Summary:" + PMD.EOL + PMD.EOL + "* warnings: 0" + PMD.EOL;
    }
    
    public String getExpectedMultiple() {
        return "* file: n/a" + PMD.EOL + "    src:  n/a:1:1" + PMD.EOL + "    rule: Foo" + PMD.EOL + "    msg:  msg" + PMD.EOL + "    code: public class Foo {}" + PMD.EOL + PMD.EOL + "    src:  n/a:1:1" + PMD.EOL + "    rule: Foo" + PMD.EOL + "    msg:  msg" + PMD.EOL + "    code: public class Foo {}" + PMD.EOL + PMD.EOL + PMD.EOL + PMD.EOL + "Summary:" + PMD.EOL + PMD.EOL + " : 2" + PMD.EOL + "* warnings: 2" + PMD.EOL;
    }
    
    public String getExpectedError(ProcessingError error) {
        return PMD.EOL + PMD.EOL + "Summary:" + PMD.EOL + PMD.EOL + "    err:  Error" + PMD.EOL + PMD.EOL + "* errors:   0" + PMD.EOL + "* warnings: 0" + PMD.EOL;
    }
}