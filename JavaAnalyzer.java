/* JavaAnalyzer.java */
/* Generated By:JavaCC: Do not edit this line. JavaAnalyzer.java */
import java.io.FileReader;
import java.io.IOException;

public class JavaAnalyzer implements JavaAnalyzerConstants {
    private static boolean tableHeaderPrinted = false;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java JavaAnalyzer <input_file>");
            System.exit(1);
        }

        // Read input from the file specified as a command-line argument
        FileReader inputFile = new FileReader(args[0]);
        JavaAnalyzer analyzer = new JavaAnalyzer(inputFile);
        try {
            analyzer.Start(); // Start parsing
            System.out.println("-------------------------------------------");
            System.out.println("*******************************************");
            System.out.println("*      Syntax validation successful.      *");
            System.out.println("*******************************************");
        } catch (ParseException e) {
            System.out.println("-------------------------------------------");
            System.out.println("*******************************************");
            System.err.println("Syntax error: " + e.getMessage());
            System.out.println("*******************************************");
        }
    }

    // Helper method to print tokens
    public static void printToken(String tokenType, Token token) {
        if (!tableHeaderPrinted) {
            System.out.println("-------------------------------------------");
            System.out.printf("|  %-20s | %-15s\u005cn", "Token Type", "Token Image");
            System.out.println("-------------------------------------------");
            tableHeaderPrinted = true;
        }
        System.out.printf("|  %-20s | %-15s |\u005cn", tokenType, token.image);
    }

// Parser rules
  final public void Start() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case CLASS:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      ClassDeclaration();
    }
    jj_consume_token(0);
  }

  final public void ClassDeclaration() throws ParseException {
    jj_consume_token(CLASS);
JavaAnalyzer.printToken("CLASS", token);
    jj_consume_token(IDENTIFIER);
JavaAnalyzer.printToken("IDENTIFIER", token);
    jj_consume_token(LBRACE);
JavaAnalyzer.printToken("LBRACE", token);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case INT:
      case IDENTIFIER:
      case INTEGER_LITERAL:
      case LPAREN:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      Statement();
    }
    jj_consume_token(RBRACE);
JavaAnalyzer.printToken("RBRACE", token);
  }

  final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INT:{
      VariableDeclaration();
      break;
      }
    case IF:{
      IfStatement();
      break;
      }
    case WHILE:{
      WhileStatement();
      break;
      }
    case IDENTIFIER:
    case INTEGER_LITERAL:
    case LPAREN:{
      ExpressionStatement();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void VariableDeclaration() throws ParseException {
    jj_consume_token(INT);
JavaAnalyzer.printToken("INT", token);
    jj_consume_token(IDENTIFIER);
JavaAnalyzer.printToken("IDENTIFIER", token);
    jj_consume_token(ASSIGN);
JavaAnalyzer.printToken("ASSIGN", token);
    Expression();
    jj_consume_token(SEMICOLON);
JavaAnalyzer.printToken("SEMICOLON", token);
  }

  final public void IfStatement() throws ParseException {
    jj_consume_token(IF);
JavaAnalyzer.printToken("IF", token);
    jj_consume_token(LPAREN);
JavaAnalyzer.printToken("LPAREN", token);
    Expression();
    jj_consume_token(RPAREN);
JavaAnalyzer.printToken("RPAREN", token);
    jj_consume_token(LBRACE);
JavaAnalyzer.printToken("LBRACE", token);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case INT:
      case IDENTIFIER:
      case INTEGER_LITERAL:
      case LPAREN:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      Statement();
    }
    jj_consume_token(RBRACE);
JavaAnalyzer.printToken("RBRACE", token);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ELSE:{
      jj_consume_token(ELSE);
JavaAnalyzer.printToken("ELSE", token);
      jj_consume_token(LBRACE);
JavaAnalyzer.printToken("LBRACE", token);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case WHILE:
        case INT:
        case IDENTIFIER:
        case INTEGER_LITERAL:
        case LPAREN:{
          ;
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_4;
        }
        Statement();
      }
      jj_consume_token(RBRACE);
JavaAnalyzer.printToken("RBRACE", token);
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      ;
    }
  }

  final public void WhileStatement() throws ParseException {
    jj_consume_token(WHILE);
JavaAnalyzer.printToken("WHILE", token);
    jj_consume_token(LPAREN);
JavaAnalyzer.printToken("LPAREN", token);
    Expression();
    jj_consume_token(RPAREN);
JavaAnalyzer.printToken("RPAREN", token);
    jj_consume_token(LBRACE);
JavaAnalyzer.printToken("LBRACE", token);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case INT:
      case IDENTIFIER:
      case INTEGER_LITERAL:
      case LPAREN:{
        ;
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        break label_5;
      }
      Statement();
    }
    jj_consume_token(RBRACE);
JavaAnalyzer.printToken("RBRACE", token);
  }

  final public void ExpressionStatement() throws ParseException {
    Expression();
    jj_consume_token(SEMICOLON);
JavaAnalyzer.printToken("SEMICOLON", token);
  }

  final public void Expression() throws ParseException {
    LogicalOrExpression();
  }

  final public void LogicalOrExpression() throws ParseException {
    LogicalAndExpression();
    label_6:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_6;
      }
      jj_consume_token(EQ);
      LogicalAndExpression();
    }
  }

  final public void LogicalAndExpression() throws ParseException {
    EqualityExpression();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LT:
      case GT:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LT:{
        jj_consume_token(LT);
        EqualityExpression();
        break;
        }
      case GT:{
        jj_consume_token(GT);
        EqualityExpression();
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void EqualityExpression() throws ParseException {
    AdditiveExpression();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EQ:{
        ;
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        break label_8;
      }
      jj_consume_token(EQ);
      AdditiveExpression();
    }
  }

  final public void AdditiveExpression() throws ParseException {
    MultiplicativeExpression();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:{
        ;
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        MultiplicativeExpression();
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        MultiplicativeExpression();
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void MultiplicativeExpression() throws ParseException {
    Factor();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:
      case DIVIDE:{
        ;
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:{
        jj_consume_token(TIMES);
        Factor();
        break;
        }
      case DIVIDE:{
        jj_consume_token(DIVIDE);
        Factor();
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFIER:{
      jj_consume_token(IDENTIFIER);
JavaAnalyzer.printToken("IDENTIFIER", token);
      break;
      }
    case INTEGER_LITERAL:{
      jj_consume_token(INTEGER_LITERAL);
JavaAnalyzer.printToken("INTEGER_LITERAL", token);
      break;
      }
    case LPAREN:{
      jj_consume_token(LPAREN);
JavaAnalyzer.printToken("LPAREN", token);
      Expression();
      jj_consume_token(RPAREN);
JavaAnalyzer.printToken("RPAREN", token);
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_11()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_18()
 {
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(EQ)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_16()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3R_14()
 {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3R_13()
 {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_12()
 {
    if (jj_3R_13()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public JavaAnalyzerTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2,0x200c034,0x200c034,0x200c034,0x200c034,0x8,0x200c034,0x1800000,0x1800000,0x400000,0x60000,0x60000,0x180000,0x180000,0x200c000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public JavaAnalyzer(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JavaAnalyzer(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JavaAnalyzerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public JavaAnalyzer(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JavaAnalyzerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public JavaAnalyzer(JavaAnalyzerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(JavaAnalyzerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[37];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 37; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
