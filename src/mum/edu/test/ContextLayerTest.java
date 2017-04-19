package mum.edu.test;

import mum.edu.businesslogic.model.Balance;
import mum.edu.databaseLayer.contextLayer.ContextLayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by orifjon9 on 4/19/2017.
 */
public class ContextLayerTest {
    @Test
    public void checkContextLayerModel(){
        List<Balance> balances = ContextLayer.Model().Balances().getElements();

        Assert.assertEquals(balances.size() > 0, true);
    }
}
