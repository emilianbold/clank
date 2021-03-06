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

package org.llvm.adt;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;

/// \brief An iterator type that allows iterating over the pointees via some
/// other iterator.
///
/// The typical usage of this is to expose a type that iterates over Ts, but
/// which is implemented with some iterator over T*s:
///
/// \code
///   typedef pointee_iterator<SmallVectorImpl<T *>::iterator> iterator;
/// \endcode
/*template <typename WrappedIteratorT, typename T = typename std::remove_reference<decltype(**std::declval<WrappedIteratorT>())>::type> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 243,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 228,
 FQN="llvm::pointee_iterator", NM="_ZN4llvm16pointee_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN4llvm16pointee_iteratorE")
//</editor-fold>
public class/*struct*/ pointee_iterator<T> extends iterator_adaptor_base<pointee_iterator<T>, type$iterator<?, T>, std.iterator, T/*P*/, T/*&*/> {
  //<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 236,
   FQN="llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>", NM="_ZN4llvm16pointee_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZN4llvm16pointee_iteratorC1Ev")
  //</editor-fold>
  public pointee_iterator()/* = default*/ {
  }


  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 253,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 237,
   FQN="llvm::pointee_iterator::pointee_iterator<WrappedIteratorT, T>", NM="Tpl__ZN4llvm16pointee_iteratorC1EOT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=Tpl__ZN4llvm16pointee_iteratorC1EOT_")
  //</editor-fold>
  public pointee_iterator(final type$iterator<?, T> /*&&*/u) {
    // : pointee_iterator<WrappedIteratorT, T>::iterator_adaptor_base(std::forward<U &&>(u)) 
    /*ParenListExpr*/super(u);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::pointee_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 241,
   FQN="llvm::pointee_iterator::operator*", NM="_ZNK4llvm16pointee_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Driver.cpp -nm=_ZNK4llvm16pointee_iteratordeEv")
  //</editor-fold>
  @Override public T /*&*/ $star() /*const*/ {
    return I.$star();
  }

  public type$ref<T> /*&*/ $star$ref() /*const*/ {
    return I.star$ref();
  }

  public pointee_iterator(pointee_iterator $Prm0)/* = default*/ {
    super(JD$BaseOf.INSTANCE, $Prm0);
  }  
  
  @Override public pointee_iterator clone() { return new pointee_iterator(this); }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
