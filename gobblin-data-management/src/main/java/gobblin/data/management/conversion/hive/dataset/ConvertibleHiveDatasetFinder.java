/*
 * Copyright (C) 2014-2016 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 */
package gobblin.data.management.conversion.hive.dataset;

import java.io.IOException;
import java.util.Properties;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hive.metastore.api.Table;

import com.typesafe.config.Config;

import gobblin.data.management.copy.hive.HiveDatasetFinder;
import gobblin.metrics.event.EventSubmitter;


/**
 * A {@link HiveDatasetFinder} to create {@link ConvertibleHiveDataset}s
 */
public class ConvertibleHiveDatasetFinder extends HiveDatasetFinder {

  public ConvertibleHiveDatasetFinder(FileSystem fs, Properties properties, EventSubmitter eventSubmitter) throws IOException {
    super(fs, properties, eventSubmitter);
  }

  protected ConvertibleHiveDataset createHiveDataset(Table table, Config config) {
    return new ConvertibleHiveDataset(super.fs, super.clientPool, new org.apache.hadoop.hive.ql.metadata.Table(table),
        config);
  }
}
