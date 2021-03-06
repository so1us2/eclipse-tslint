/*
 * Copyright 2013 Palantir Technologies, Inc.
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

package com.palantir.tslint;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public final class TSLintPlugin extends AbstractUIPlugin {

    // The shared instance
    private static TSLintPlugin plugin;
    public static final String ID = "com.palantir.tslint";

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static String getLinterPath() throws IOException {
        File bundleFile = FileLocator.getBundleFile(TSLintPlugin.getDefault().getBundle());
        File tslintFile = new File(bundleFile, "node_modules/tslint/bin/tslint-cli.js");

        return tslintFile.getAbsolutePath();
    }

    public static TSLintPlugin getDefault() {
        return plugin;
    }

}
