/*
 *
 *   Copyright (c) 2023 Bayerische Motoren Werke Aktiengesellschaft
 *
 *   See the NOTICE file(s) distributed with this work for additional
 *   information regarding copyright ownership.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Apache License, Version 2.0 which is available at
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *   WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *   License for the specific language governing permissions and limitations
 *   under the License.
 *
 *   SPDX-License-Identifier: Apache-2.0
 *
 */

package com.huawei.cloud.transfer.obs;

import org.eclipse.edc.connector.dataplane.spi.pipeline.PipelineService;
import org.eclipse.edc.runtime.metamodel.annotation.Extension;
import org.eclipse.edc.runtime.metamodel.annotation.Inject;
import org.eclipse.edc.spi.system.ServiceExtension;
import org.eclipse.edc.spi.system.ServiceExtensionContext;

@Extension(ObsTransferExtension.NAME)
public class ObsTransferExtension implements ServiceExtension {

    public static final String NAME = "Huawei OBS Data Transfer Extension";

    @Inject
    private PipelineService pipelineService;

    @Override
    public void initialize(ServiceExtensionContext context) {

        var sourceFactory = new ObsDataSourceFactory();
        pipelineService.registerFactory(sourceFactory);

        var sinkFactory = new ObsDataSinkFactory();
        pipelineService.registerFactory(sinkFactory);
    }

    @Override
    public String name() {
        return NAME;
    }
}