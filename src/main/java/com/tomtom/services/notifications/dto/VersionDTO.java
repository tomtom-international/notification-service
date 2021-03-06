/*
 * Copyright (C) 2012-2021, TomTom (http://tomtom.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tomtom.services.notifications.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tomtom.services.notifications.ApiConstants;
import com.tomtom.speedtools.apivalidation.ApiDTO;
import com.tomtom.speedtools.utils.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class defines the data transfer object for the "/version" method.
 * It contains only the version string, which is the POM version of the service.
 */
@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
@JsonInclude(Include.NON_EMPTY)
@XmlRootElement(name = "version")
@XmlAccessorType(XmlAccessType.FIELD)
public final class VersionDTO extends ApiDTO {

    /**
     * Version string of service. No assumptions can be made on its format.
     */
    @JsonProperty("version")
    @XmlElement(name = "version")
    @Nullable
    private String version;

    @Override
    public void validate() {
        validator().start();
        validator().checkString(true, "version", version,
                ApiConstants.API_VERSION_MIN_LENGTH,
                ApiConstants.API_VERSION_MAX_LENGTH);
        validator().done();
    }

    public VersionDTO(@Nonnull final String version) {
        super();
        setVersion(version);
    }

    @SuppressWarnings("UnusedDeclaration")
    @Deprecated
    private VersionDTO() {
        // Default constructor required by JAX-B.
        super();
    }

    @Nonnull
    public String getVersion() {
        beforeGet();
        //noinspection ConstantConditions
        return version;
    }

    public void setVersion(@Nonnull final String version) {
        beforeSet();
        this.version = StringUtils.trim(version);
    }

}
