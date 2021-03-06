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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.type$ptr;
import org.clank.support.aliases.uint$ptr;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.checkers.impl.java.ProgramStatePartialTrait;
import org.llvm.adt.ImutKeyValueInfo$PtrUInt;


// Partial-specialization for ImmutableMap.
/*template <typename Key, typename Data, typename Info> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 58,
 FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEEE")
//</editor-fold>
public abstract class/*struct*/ ProgramStatePartialTraitImmutableMapPtrUInt</*typename*/ Key> implements ProgramStatePartialTrait<ImmutableMapPtrUInt<Key>> {
  /*typedef llvm::ImmutableMap<Key, Data, Info> data_type*/
//  public final class data_type extends ImmutableMap<Key, Data, Info>{ };
  /*typedef typename data_type::Factory &context_type*/
//  public final class context_type extends  ImmutableMap.Factory<Key, Data, Info> /*&*/ { };
  /*typedef Key key_type*/
//  public final class key_type extends Key{ };
  /*typedef Data value_type*/
//  public final class value_type extends Data{ };
  /*typedef const value_type *lookup_type*/
//  public final class lookup_type extends /*const*/ Data /*P*/ { };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::MakeData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 66,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::MakeData", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE8MakeDataEPKPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE8MakeDataEPKPv")
  //</editor-fold>
  public ImmutableMapPtrUInt<Key> MakeData(type$ptr<Object>/*void P const P*/ p) {
    return Native.$bool(p) ? new ImmutableMapPtrUInt<Key>(( ImutAVLTreePtrUIntType<Key, std.pairTypeUInt<Key>> /*P*/ )p.$star()) : new ImmutableMapPtrUInt<Key>((ImutAVLTreePtrUIntType<Key, std.pairTypeUInt<Key>>)null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::MakeVoidPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 70,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::MakeVoidPtr", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE11MakeVoidPtrES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE11MakeVoidPtrES7_")
  //</editor-fold>
  public Object/*void P*/ MakeVoidPtr(ImmutableMapPtrUInt<Key> B) {
    return B.getRoot();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::Lookup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 73,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::Lookup", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE6LookupES7_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE6LookupES7_S4_")
  //</editor-fold>
  public /*const*/ /*uint*/uint$ptr /*P*/ Lookup(ImmutableMapPtrUInt<Key> B, Key K) {
    return B.lookup(K);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::Set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 76,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::Set", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE3SetES7_S4_S5_RNS7_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE3SetES7_S4_S5_RNS7_7FactoryE")
  //</editor-fold>
  public ImmutableMapPtrUInt<Key> Set(ImmutableMapPtrUInt<Key> B, Key K, /*uint*/int E, final  ImmutableMapPtrUInt.Factory<Key> /*&*/ F) {
    return F.add(B, K, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::Remove">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 80,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::Remove", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE6RemoveES7_S4_RNS7_7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE6RemoveES7_S4_RNS7_7FactoryE")
  //</editor-fold>
  public ImmutableMapPtrUInt<Key> Remove(ImmutableMapPtrUInt<Key> B, Key K, final  ImmutableMapPtrUInt.Factory<Key> /*&*/ F) {
    return F.remove(B, K);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::MakeContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 84,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::MakeContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE11MakeContextEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE11MakeContextEPv")
  //</editor-fold>
  public /*inline*/  ImmutableMapPtrUInt.Factory<Key> /*&*/ MakeContext(Object/*void P*/ p) {
    return Native.$star((( ImmutableMapPtrUInt.Factory<Key> /*P*/ )p));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::CreateContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 88,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::CreateContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE13CreateContextERNS2_20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE13CreateContextERNS2_20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public Object/*void P*/ CreateContext(final BumpPtrAllocatorImpl /*&*/ Alloc) {
//    return new  ImmutableMapPtrUInt.Factory<Key>(( Alloc ));
    return new ImmutableMapPtrUInt.Factory<Key/*P*/>(ImutKeyValueInfo$PtrUInt.$Info(), Alloc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::DeleteContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramStateTrait.h", line = 92,
   FQN="clang::ento::ProgramStatePartialTrait<ImmutableMap<type-parameter-0-0, type-parameter-0-1, type-parameter-0-2> >::DeleteContext", NM="_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE13DeleteContextEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento24ProgramStatePartialTraitIN4llvm12ImmutableMapIT_T0_T1_EEE13DeleteContextEPv")
  //</editor-fold>
  public void DeleteContext(Object/*void P*/ Ctx) {
    /*delete*/Destructors.$destroy(( ImmutableMapPtrUInt.Factory<Key> /*P*/ )Ctx);
  }

  public final Key $tryCloneKey(Key K) {
    // pointer key return as is
    return K;
  }
  
  public final /*uint*/int $tryCloneValue(/*uint*/int E) {
    return E;
  }

  @Override public final ImmutableMapPtrUInt<Key> $tryCloneData(JavaCleaner $c$, ImmutableMapPtrUInt<Key> D) {
    return $c$.track(Native.$Clone(D));
  }
    
  @Override public String toString() {
    return ""; // NOI18N
  }
}
