/**
 * 
 */

package org.komea.product.backend.service;



import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.komea.product.backend.service.business.ISettingProxy;
import org.mockito.Mockito;



/**
 * @author sleroy
 */
public class KomeaFSTest
{
    
    
    /**
     * Tests the functionalities of Komea FS.
     * 
     * @throws java.lang.Exception
     */
    @SuppressWarnings("resource")
    @Test
    public void testKomeaFS() throws Exception {
    
    
        final KomeaFS komeaFS = new KomeaFS();
        final ISettingProxy mock = Mockito.mock(ISettingProxy.class);
        Mockito.when(mock.get()).thenReturn(new File("src/test/resources/fakeS"));
        komeaFS.setStorage_path(mock);
        final IPluginFileSystem fileSystem = komeaFS.getFileSystem("truc");
        Assert.assertNotNull(fileSystem);
        Assert.assertTrue(fileSystem.existResource("example.txt"));
        final String original =
                IOUtils.toString(new FileInputStream("src/test/resources/fakeS/truc/example.txt"));
        final String received = IOUtils.toString(fileSystem.open("example.txt"));
        Assert.assertEquals(original, received);
    }
    
}