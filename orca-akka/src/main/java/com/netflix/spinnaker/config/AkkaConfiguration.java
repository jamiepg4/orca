/*
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.config;

import akka.cluster.sharding.ClusterSharding;
import com.netflix.spinnaker.orca.batch.AkkaExecutionRunner;
import com.netflix.spinnaker.orca.batch.AkkaTaskTaskletAdapter;
import com.netflix.spinnaker.orca.batch.TaskTaskletAdapter;
import com.netflix.spinnaker.orca.pipeline.ExecutionRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${akka.enabled:true}")
@ComponentScan("com.netflix.spinnaker.orca.actorsystem")
public class AkkaConfiguration {
  @Bean
  TaskTaskletAdapter akkaTaskTaskletAdapter(ClusterSharding clusterSharding) {
    return new AkkaTaskTaskletAdapter(clusterSharding);
  }

  @Bean
  ExecutionRunner akkaExecutionRunner(ClusterSharding clusterSharding) {
    return new AkkaExecutionRunner(clusterSharding);
  }
}
