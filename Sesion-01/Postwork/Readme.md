## Sesión 1: Compilación de markdown

### 🎯 OBJETIVO

- Compilar un archivo en lenguaje Markdown a HTML

### DESARROLLO

¿Conoces lo que es Markdown? Si no es así ¡no te preocupes! En el siguiente [enlace](https://programmerclick.com/article/13741359806/) encontrarás una explicación bastante clara pero en resumen, es un lenguaje de marcado que permite enriquecer textos planos de una manera simple y es muy utilizado en Git para crear documentación o el famoso archivo llamado README.md.

La misión es transformar este [ejemplo](http://www.unexpected-vortices.com/sw/rippledoc/quick-markdown-example.html) de Markdown en HTML a través de Gradle usando [Gradle Markdown Plugin](https://github.com/kordamp/markdown-gradle-plugin).

> 💡 *Nota: En la documentación viene la explicación de como agregar el plugin al archivo build.gradle, así como las instrucciones para crear las carpetas correspondientes y que el comando markdownToHtml reconozca dónde esta el archivo markdown.*

<details>
  <summary>Solución</summary>

  De acuerdo a la documentación del plugin hay que generar la siguiente estructura de carpetas:

  `src` > `markdown`

  En la carpeta `markdown` crearemos un archivo llamando `example.md` con el siguiente contenido (obtenido en el enlace que viene en la descripción del Postwork):

  ```markdown
  An h1 header
  ============

  Paragraphs are separated by a blank line.

  2nd paragraph. *Italic*, **bold**, and `monospace`. Itemized lists
  look like:

    * this one
    * that one
    * the other one

  Note that --- not considering the asterisk --- the actual text
  content starts at 4-columns in.

  > Block quotes are
  > written like so.
  >
  > They can span multiple paragraphs,
  > if you like.

  Use 3 dashes for an em-dash. Use 2 dashes for ranges (ex., "it's all
  in chapters 12--14"). Three dots ... will be converted to an ellipsis.
  Unicode is supported. ☺



  An h2 header
  ------------

  Here's a numbered list:

  1. first item
  2. second item
  3. third item

  Note again how the actual text starts at 4 columns in (4 characters
  from the left side). Here's a code sample:

      # Let me re-iterate ...
      for i in 1 .. 10 { do-something(i) }

  As you probably guessed, indented 4 spaces. By the way, instead of
  indenting the block, you can use delimited blocks, if you like:

  ~~~
  define foobar() {
      print "Welcome to flavor country!";
  }
  ~~~

  (which makes copying & pasting easier). You can optionally mark the
  delimited block for Pandoc to syntax highlight it:

  ~~~python
  import time
  # Quick, count to ten!
  for i in range(10):
      # (but not *too* quick)
      time.sleep(0.5)
      print(i)
  ~~~



  ### An h3 header ###

  Now a nested list:

  1. First, get these ingredients:

        * carrots
        * celery
        * lentils

  2. Boil some water.

  3. Dump everything in the pot and follow
      this algorithm:

          find wooden spoon
          uncover pot
          stir
          cover pot
          balance wooden spoon precariously on pot handle
          wait 10 minutes
          goto first step (or shut off burner when done)

      Do not bump wooden spoon or it will fall.

  Notice again how text always lines up on 4-space indents (including
  that last line which continues item 3 above).

  Here's a link to [a website](http://foo.bar), to a [local
  doc](local-doc.html), and to a [section heading in the current
  doc](#an-h2-header). Here's a footnote [^1].

  [^1]: Some footnote text.

  Tables can look like this:

  Name           Size  Material      Color
  ------------- -----  ------------  ------------
  All Business      9  leather       brown
  Roundabout       10  hemp canvas   natural
  Cinderella       11  glass         transparent

  Table: Shoes sizes, materials, and colors.

  (The above is the caption for the table.) Pandoc also supports
  multi-line tables:

  --------  -----------------------
  Keyword   Text
  --------  -----------------------
  red       Sunsets, apples, and
            other red or reddish
            things.

  green     Leaves, grass, frogs
            and other things it's
            not easy being.
  --------  -----------------------

  A horizontal rule follows.

  ***

  Here's a definition list:

  apples
    : Good for making applesauce.

  oranges
    : Citrus!

  tomatoes
    : There's no "e" in tomatoe.

  Again, text is indented 4 spaces. (Put a blank line between each
  term and  its definition to spread things out more.)

  Here's a "line block" (note how whitespace is honored):

  | Line one
  |   Line too
  | Line tree

  and images can be specified like so:

  ![example image](example-image.jpg "An exemplary image")

  Inline math equation: $\omega = d\phi / dt$. Display
  math should get its own line like so:

  $$I = \int \rho R^{2} dV$$

  And note that you can backslash-escape any punctuation characters
  which you wish to be displayed literally, ex.: \`foo\`, \*bar\*, etc.
  ```

  Posteriormente crearemos el archivo de configuración de Gradle `build.gradle` y agregaremos el plugin (estas líneas se encuentran en la documentación del plugin):

  ```groovy
  plugins {
    id 'org.kordamp.gradle.markdown' version '2.2.0'
  }
  ```

  Por último ejecutaremos el comando `gradle markdownToHtml` el cual generará un archivo llamado `example.html` en la carpeta `build/gen-html`:

  ```html
  <h1>An h1 header</h1>
  <p>Paragraphs are separated by a blank line.</p>
  <p>2nd paragraph. <em>Italic</em>, <strong>bold</strong>, and <code>monospace</code>. Itemized lists look like:</p>
  <ul>
    <li>this one</li>
    <li>that one</li>
    <li>the other one</li>
  </ul>
  <p>Note that --- not considering the asterisk --- the actual text content starts at 4-columns in.</p>
  <blockquote>
    <p>Block quotes are written like so.</p>
    <p>They can span multiple paragraphs, if you like.</p>
  </blockquote>
  <p>Use 3 dashes for an em-dash. Use 2 dashes for ranges (ex., "it's all in chapters 12--14"). Three dots ... will be converted to an ellipsis. Unicode is supported. ☺</p>
  <h2>An h2 header</h2>
  <p>Here's a numbered list:</p>
  <ol>
    <li>first item</li>
    <li>second item</li>
    <li>third item</li>
  </ol>
  <p>Note again how the actual text starts at 4 columns in (4 characters from the left side). Here's a code sample:</p>
  <pre><code># Let me re-iterate ...
  for i in 1 .. 10 { do-something(i) }
  </code></pre>
  <p>As you probably guessed, indented 4 spaces. By the way, instead of indenting the block, you can use delimited blocks, if you like:</p>
  <p>~~~ define foobar() {  print "Welcome to flavor country!"; }</p>
  <p>~~~</p>
  <p>(which makes copying &amp; pasting easier). You can optionally mark the delimited block for Pandoc to syntax highlight it:</p>
  <p>~~~python import time</p>
  <h1>Quick, count to ten!</h1>
  <p>for i in range(10):  # (but not <em>too</em> quick)  time.sleep(0.5)  print(i) ~~~</p>
  <h3>An h3 header</h3>
  <p>Now a nested list:</p>
  <ol>
    <li>
      <p>First, get these ingredients:</p>
      <ul>
        <li>carrots</li>
        <li>celery</li>
        <li>lentils</li>
      </ul>
    </li>
    <li>
    <p>Boil some water.</p></li>
    <li>
      <p>Dump everything in the pot and follow this algorithm:</p>
      <pre><code>find wooden spoon
  uncover pot
  stir
  cover pot
  balance wooden spoon precariously on pot handle
  wait 10 minutes
  goto first step (or shut off burner when done)
  </code></pre>
      <p>Do not bump wooden spoon or it will fall.</p>
    </li>
  </ol>
  <p>Notice again how text always lines up on 4-space indents (including that last line which continues item 3 above).</p>
  <p>Here's a link to <a href="http://foo.bar">a website</a>, to a <a href="local-doc.html">local doc</a>, and to a <a href="#an-h2-header">section heading in the current doc</a>. Here's a footnote [^1].</p>
  <p>[^1]: Some footnote text.</p>
  <p>Tables can look like this:</p>
  <p>Name Size Material Color ------------- ----- ------------ ------------ All Business 9 leather brown Roundabout 10 hemp canvas natural Cinderella 11 glass transparent</p>
  <p>Table: Shoes sizes, materials, and colors.</p>
  <p>(The above is the caption for the table.) Pandoc also supports multi-line tables:</p>
  <p>-------- ----------------------- Keyword Text -------- ----------------------- red Sunsets, apples, and  other red or reddish  things.</p>
  <p>green Leaves, grass, frogs  and other things it's  not easy being. -------- -----------------------</p>
  <p>A horizontal rule follows.</p>
  <hr/>
  <p>Here's a definition list:</p>
  <p>apples  : Good for making applesauce.</p>
  <p>oranges  : Citrus!</p>
  <p>tomatoes  : There's no "e" in tomatoe.</p>
  <p>Again, text is indented 4 spaces. (Put a blank line between each term and its definition to spread things out more.)</p>
  <p>Here's a "line block" (note how whitespace is honored):</p>
  <p>| Line one | Line too | Line tree</p>
  <p>and images can be specified like so:</p>
  <p><img src="example-image.jpg" alt="example image" title="An exemplary image" /></p>
  <p>Inline math equation: $\omega = d\phi / dt$. Display math should get its own line like so:</p>
  <p>$$I = \int \rho R^{2} dV$$</p>
  <p>And note that you can backslash-escape any punctuation characters which you wish to be displayed literally, ex.: `foo`, *bar*, etc.</p>
  ```
</details>