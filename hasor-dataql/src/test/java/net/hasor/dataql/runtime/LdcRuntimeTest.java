package net.hasor.dataql.runtime;
import net.hasor.dataql.AbstractTestResource;
import net.hasor.dataql.DataModel;
import net.hasor.dataql.OptionValue;
import net.hasor.dataql.Query;
import net.hasor.dataql.domain.ValueModel;
import org.junit.Test;

public class LdcRuntimeTest extends AbstractTestResource implements OptionValue {
    @Test
    public void LDC_B_1_Test() throws Exception {
        Query compilerQL = compilerQL("return true;");
        DataModel dataModel = compilerQL.execute().getData();
        //
        assert dataModel.isValueModel();
        assert ((ValueModel) dataModel).isBoolean();
        assert ((ValueModel) dataModel).asBoolean();
    }

    @Test
    public void LDC_B_2_Test() throws Exception {
        Query compilerQL = compilerQL("return false;");
        DataModel dataModel = compilerQL.execute().getData();
        //
        assert dataModel.isValueModel();
        assert ((ValueModel) dataModel).isBoolean();
        assert !((ValueModel) dataModel).asBoolean();
    }

    @Test
    public void LDC_B_3_Test() throws Exception {
        Query compilerQL = compilerQL("var a = true ;return a");
        DataModel dataModel = compilerQL.execute().getData();
        //
        assert dataModel.isValueModel();
        assert ((ValueModel) dataModel).isBoolean();
        assert ((ValueModel) dataModel).asBoolean();
    }

    @Test
    public void LDC_B_4_Test() throws Exception {
        Query compilerQL = compilerQL("var a = false ;return a");
        DataModel dataModel = compilerQL.execute().getData();
        //
        assert dataModel.isValueModel();
        assert ((ValueModel) dataModel).isBoolean();
        assert !((ValueModel) dataModel).asBoolean();
    }

    @Test
    public void LDC_D_1_Test() throws Exception {
        Query compilerQL = compilerQL("return 123");
        DataModel dataModel = compilerQL.execute().getData();
        //
        assert dataModel.isValueModel();
        assert ((ValueModel) dataModel).isNumber();
        assert ((ValueModel) dataModel).isInt();
        assert ((ValueModel) dataModel).asInt() == 123;
    }

    @Test
    public void LDC_D_2_Test() throws Exception {
        Query compilerQL = compilerQL("var a = 123 ;return a");
        compilerQL.setOption(MIN_INTEGER_WIDTH, MIN_INTEGER_WIDTH_BYTE);
        DataModel dataModel = compilerQL.execute().getData();
        //
        assert dataModel.isValueModel();
        assert ((ValueModel) dataModel).isByte();
        assert ((ValueModel) dataModel).asInt() == 123;
    }
    //    @Test
    //    public void LDC_D_3_Test() throws Exception {
    //        Query compilerQL = compilerQL("return 123;");
    //        DataModel dataModel = compilerQL.execute().getData();
    //        //
    //        assert dataModel.isValueModel();
    //        assert ((ValueModel) dataModel).isInt();
    //        assert ((ValueModel) dataModel).asInt() == 123;
    //    }
    //
    //    @Test
    //    public void LDC_D_4_Test() throws Exception {
    //        Query compilerQL = compilerQL("var a = false ;return a");
    //        DataModel dataModel = compilerQL.execute().getData();
    //        //
    //        assert dataModel.isValueModel();
    //        assert ((ValueModel) dataModel).isBoolean();
    //        assert !((ValueModel) dataModel).asBoolean();
    //    }
    //    @Test
    //    public void a_test() throws Exception {
    //        QueryModel queryModel = QueryHelper.queryParser(" return (10 + 2 * 3) / 4 + 100 + 100 +  100");
    //        QIL qil = QueryHelper.queryCompiler(queryModel);
    //        QueryEngineImpl queryEngine = new QueryEngineImpl(qil);
    //        QueryImpl query = queryEngine.newQuery();
    //        query.execute();
    //    }
}