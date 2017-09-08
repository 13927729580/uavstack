/*
 * This file is part of FastClasspathScanner.
 * 
 * Author: Luke Hutchison <luke .dot. hutch .at. gmail .dot. com>
 * 
 * Hosted at: https://github.com/lukehutch/fast-classpath-scanner
 * 
 * --
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Luke Hutchison
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.github.lukehutch.fastclasspathscanner.classgraph;

import java.util.HashSet;

/** The DAG node representing an interface. */
class InterfaceNode extends DAGNode {

    /** The named interface was encountered on the classpath. */
    public InterfaceNode(final String interfaceName) {
        super(interfaceName);
    }

    /**
     * A subinterface of this interface was encountered on the classpath, but this interface has not yet been
     * encountered itself on the classpath (so this node is a placeholder until it is itself encountered).
     */
    public InterfaceNode(final String interfaceName, final InterfaceNode subinterfaceName) {
        super(interfaceName, subinterfaceName);
    }

    // ----- START
    /** All annotations */
    HashSet<String> annotationNames = new HashSet<String>();

    /** The named interface was encountered on the classpath. */
    public InterfaceNode(final String interfaceName, final HashSet<String> annotationNames) {
        super(interfaceName);
        this.encounter(annotationNames);
    }

    /**
     * A subinterface of this interface was encountered on the classpath, but this interface has not yet been
     * encountered itself on the classpath (so this node is a placeholder until it is itself encountered).
     */
    public InterfaceNode(final String interfaceName, final InterfaceNode subinterfaceName,
            final HashSet<String> annotationNames) {
        super(interfaceName, subinterfaceName);
        this.encounter(annotationNames);
    }

    /** This class was previously cited as a superclass, and now has itself been encountered on the classpath. */
    public void encounter(final HashSet<String> annotationNames) {

        super.encounter();
        this.annotationNames = annotationNames;
    }
    // ----- END

}