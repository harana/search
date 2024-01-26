package com.harana.search.client

package object viewers {

  def needsFullContent(viewer: String) =
    List("Code", "Json", "Ipynb", "Md", "Tex").contains(viewer)
}
