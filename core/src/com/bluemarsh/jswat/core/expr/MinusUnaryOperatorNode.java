/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is the JSwat Core Module. The Initial Developer of the
 * Software is Nathan L. Fiedler. Portions created by Nathan L. Fiedler
 * are Copyright (C) 2002-2010. All Rights Reserved.
 *
 * Contributor(s): Nathan L. Fiedler.
 *
 * $Id$
 */
package com.bluemarsh.jswat.core.expr;

import com.bluemarsh.jswat.parser.node.Token;
import org.openide.util.NbBundle;

/**
 * Class MinusUnaryOperatorNode implements the minus unary operator (-).
 *
 * @author  Nathan Fiedler
 */
class MinusUnaryOperatorNode extends UnaryOperatorNode {

    /**
     * Constructs a MinusUnaryOperatorNode.
     *
     * @param  node  lexical token.
     */
    MinusUnaryOperatorNode(Token node) {
        super(node);
    }

    @Override
    protected Object eval(EvaluationContext context)
            throws EvaluationException {

        Object o1 = getChild(0).evaluate(context);

        if (isDouble(o1)) {
            return new Double(0 - getDoubleValue(o1));
        } else if (isLong(o1)) {
            return new Long(0 - getLongValue(o1));
        } else if (isFloating(o1)) {
            return new Float(0 - getFloatValue(o1));
        } else if (isNumber(o1)) {
            return new Integer(0 - getIntValue(o1));
        } else {
            throw new EvaluationException(
                    NbBundle.getMessage(getClass(), "error.oper.num"), getToken());
        }
    }

    @Override
    public int precedence() {
        return 5;
    }
}
