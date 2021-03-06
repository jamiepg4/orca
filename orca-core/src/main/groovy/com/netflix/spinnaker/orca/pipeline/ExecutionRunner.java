/*
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.pipeline;

import com.netflix.spinnaker.orca.pipeline.model.Execution;
import com.netflix.spinnaker.orca.pipeline.model.Execution.ExecutionEngine;
import static java.lang.String.format;

public interface ExecutionRunner {
  <T extends Execution<T>> void start(T execution) throws Exception;

  @Deprecated
  default <T extends Execution<T>> void restart(T execution) throws Exception {
    throw new UnsupportedOperationException();
  }

  default <T extends Execution<T>> void restart(T execution, String stageId) throws Exception {
    throw new UnsupportedOperationException();
  }

  default <T extends Execution<T>> void unpause(T execution) throws Exception {
    throw new UnsupportedOperationException();
  }

  ExecutionEngine engine();

  class NoSuchStageDefinitionBuilder extends RuntimeException {
    public NoSuchStageDefinitionBuilder(String type) {
      super(format("No StageDefinitionBuilder implementation for %s found", type));
    }
  }
}
