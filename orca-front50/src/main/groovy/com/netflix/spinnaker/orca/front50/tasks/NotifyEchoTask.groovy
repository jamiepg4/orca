/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.netflix.spinnaker.orca.front50.tasks

import com.netflix.spinnaker.orca.echo.tasks.AbstractNotifyEchoTask
import groovy.transform.CompileStatic

@CompileStatic
class NotifyEchoTask extends AbstractNotifyEchoTask {
  @Override
  String getNotificationSource() {
    return "front50"
  }

  @Override
  String getApplicationName(Map<String, Object> stageContext) {
    def application = stageContext.application as Map<String, String>
    return application.name
  }
}
