/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clank.support.aliases;

import org.clank.support.Converted;
import org.clank.support.NativeTrace;
import static org.clank.support.NativeType.*;


//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/memimpl.tpl")
//</editor-fold>
public final class ushort$mem implements ushort$memory {
    
    private final char[] array;

    public ushort$mem(char value) {
        array = new char[1];
        array[0] = value;
    }

    public ushort$mem(char[] array) {
        this.array = array;
    }

    @Override
    public char $set(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] = value;
    }

    @Override
    public char $set$andassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] &= value;
    }

    @Override
    public char $set$xorassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] ^= value;
    }

    @Override
    public char $set$orassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] |= value;
    }

    

    @Override
    public char $set$addassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] += value;
    }

    @Override
    public char $set$minusassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] -= value;
    }

    @Override
    public char $set$starassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] *= value;
    }

    @Override
    public char $set$slashassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] /= value;
    }

    @Override
    public char $set$modassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] %= value;
    }

    @Override
    public char $set$lshiftassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] <<= value;
    }

    @Override
    public char $set$rshiftassign(int index, char value) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index] >>= value;
    }

    @Override
    public char $set$postInc(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index]++;
    }

    @Override
    public char $set$postDec(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return array[(int)index]--;
    }

    @Override
    public char $set$preInc(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return ++array[(int)index];
    }

    @Override
    public char $set$preDec(int index) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        return --array[(int)index];
    }

    

    @Override
    public char $at(int index) {
        return array[(int)index];
    }

    @Override
    public int sizeof() {
      return BYTES_IN_USHORT;
    }
    
    @Override
    public int size() {
        return array == null ? 0 : array.length;
    }
    
    @Override
    public int toByteIndex(int index) {
        return index * sizeof();
    }

    @Override
    public int fromByteIndex(int index) {
        return index / sizeof();
    }        

    @Override
    public boolean $eq(org.clank.support.NativeMemory.memory other) {
      if (this == other) {
        return true;
      } else if (other instanceof ushort$mem) {
        return this.array == ((ushort$mem) other).array;
      } else {
        return false;
      }
    }
    
    public char[] $array() {
        return array;
    }
}