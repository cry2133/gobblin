package gobblin.source.extractor.hadoop;

import gobblin.configuration.ConfigurationKeys;
import gobblin.configuration.SourceState;
import gobblin.source.extractor.filebased.FileBasedHelperException;

import org.apache.hadoop.conf.Configuration;
import org.testng.annotations.Test;

public class HadoopFsHelperTest {

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConnectFailsWithS3URLWithoutAWSCredentials() throws FileBasedHelperException {
    Configuration conf = new Configuration(); // plain conf, no S3 credentials
    SourceState sourceState = new SourceState();
    sourceState.setProp(ConfigurationKeys.SOURCE_FILEBASED_FS_URI, "s3://support.elasticmapreduce/spark/install-spark/");
    HadoopFsHelper fsHelper = new HadoopFsHelper(sourceState, conf);
    fsHelper.connect();
  }
}
