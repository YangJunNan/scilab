/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018-2021 Free Software Foundation,
   Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

#ifndef YY_YY_Y_TAB_H_INCLUDED
# define YY_YY_Y_TAB_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 1
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token kinds.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    YYEMPTY = -2,
    YYEOF = 0,                     /* "end of file"  */
    YYerror = 256,                 /* error  */
    YYUNDEF = 257,                 /* "invalid token"  */
    DOTS = 258,                    /* "line break"  */
    EOL = 259,                     /* "end of line"  */
    SPACES = 260,                  /* "spaces"  */
    BOOLTRUE = 261,                /* "%t or %T"  */
    BOOLFALSE = 262,               /* "%f or %F"  */
    QUOTE = 263,                   /* "'"  */
    NOT = 264,                     /* "~ or @"  */
    DOLLAR = 265,                  /* "$"  */
    COMMA = 266,                   /* ","  */
    COLON = 267,                   /* ":"  */
    SEMI = 268,                    /* ";"  */
    LPAREN = 269,                  /* "("  */
    RPAREN = 270,                  /* ")"  */
    LBRACK = 271,                  /* "["  */
    RBRACK = 272,                  /* "]"  */
    LBRACE = 273,                  /* "{"  */
    RBRACE = 274,                  /* "}"  */
    DOT = 275,                     /* "."  */
    DOTQUOTE = 276,                /* ".'"  */
    PLUS = 277,                    /* "+"  */
    MINUS = 278,                   /* "-"  */
    TIMES = 279,                   /* "*"  */
    DOTTIMES = 280,                /* ".*"  */
    KRONTIMES = 281,               /* ".*."  */
    CONTROLTIMES = 282,            /* "*."  */
    RDIVIDE = 283,                 /* "/"  */
    DOTRDIVIDE = 284,              /* "./"  */
    CONTROLRDIVIDE = 285,          /* "/."  */
    KRONRDIVIDE = 286,             /* "./."  */
    LDIVIDE = 287,                 /* "\\"  */
    DOTLDIVIDE = 288,              /* ".\\"  */
    CONTROLLDIVIDE = 289,          /* "\\."  */
    KRONLDIVIDE = 290,             /* ".\\."  */
    POWER = 291,                   /* "** or ^"  */
    DOTPOWER = 292,                /* ".^"  */
    EQ = 293,                      /* "=="  */
    NE = 294,                      /* "<> or ~="  */
    LT = 295,                      /* "<"  */
    LE = 296,                      /* "<="  */
    GT = 297,                      /* ">"  */
    GE = 298,                      /* ">="  */
    AND = 299,                     /* "&"  */
    ANDAND = 300,                  /* "&&"  */
    OR = 301,                      /* "|"  */
    OROR = 302,                    /* "||"  */
    ASSIGN = 303,                  /* "="  */
    IF = 304,                      /* "if"  */
    THEN = 305,                    /* "then"  */
    ELSE = 306,                    /* "else"  */
    ELSEIF = 307,                  /* "elseif"  */
    END = 308,                     /* "end"  */
    SELECT = 309,                  /* "select"  */
    SWITCH = 310,                  /* "switch"  */
    CASE = 311,                    /* "case"  */
    OTHERWISE = 312,               /* "otherwise"  */
    FUNCTION = 313,                /* "function"  */
    ENDFUNCTION = 314,             /* "endfunction"  */
    FOR = 315,                     /* "for"  */
    WHILE = 316,                   /* "while"  */
    DO = 317,                      /* "do"  */
    BREAK = 318,                   /* "break"  */
    CONTINUE = 319,                /* "continue"  */
    TRY = 320,                     /* "try"  */
    CATCH = 321,                   /* "catch"  */
    RETURN = 322,                  /* "return"  */
    FLEX_ERROR = 323,              /* FLEX_ERROR  */
    STR = 324,                     /* "string"  */
    ID = 325,                      /* "identifier"  */
    VARINT = 326,                  /* "integer"  */
    VARFLOAT = 327,                /* "float"  */
    NUM = 328,                     /* "number"  */
    PATH = 329,                    /* "path"  */
    COMMENT = 330,                 /* "line comment"  */
    BLOCKCOMMENT = 331,            /* "block comment"  */
    TOPLEVEL = 332,                /* TOPLEVEL  */
    HIGHLEVEL = 333,               /* HIGHLEVEL  */
    UPLEVEL = 334,                 /* UPLEVEL  */
    LISTABLE = 335,                /* LISTABLE  */
    CONTROLBREAK = 336,            /* CONTROLBREAK  */
    UMINUS = 337,                  /* UMINUS  */
    UPLUS = 338,                   /* UPLUS  */
    FUNCTIONCALL = 339             /* FUNCTIONCALL  */
  };
  typedef enum yytokentype yytoken_kind_t;
#endif
/* Token kinds.  */
#define YYEMPTY -2
#define YYEOF 0
#define YYerror 256
#define YYUNDEF 257
#define DOTS 258
#define EOL 259
#define SPACES 260
#define BOOLTRUE 261
#define BOOLFALSE 262
#define QUOTE 263
#define NOT 264
#define DOLLAR 265
#define COMMA 266
#define COLON 267
#define SEMI 268
#define LPAREN 269
#define RPAREN 270
#define LBRACK 271
#define RBRACK 272
#define LBRACE 273
#define RBRACE 274
#define DOT 275
#define DOTQUOTE 276
#define PLUS 277
#define MINUS 278
#define TIMES 279
#define DOTTIMES 280
#define KRONTIMES 281
#define CONTROLTIMES 282
#define RDIVIDE 283
#define DOTRDIVIDE 284
#define CONTROLRDIVIDE 285
#define KRONRDIVIDE 286
#define LDIVIDE 287
#define DOTLDIVIDE 288
#define CONTROLLDIVIDE 289
#define KRONLDIVIDE 290
#define POWER 291
#define DOTPOWER 292
#define EQ 293
#define NE 294
#define LT 295
#define LE 296
#define GT 297
#define GE 298
#define AND 299
#define ANDAND 300
#define OR 301
#define OROR 302
#define ASSIGN 303
#define IF 304
#define THEN 305
#define ELSE 306
#define ELSEIF 307
#define END 308
#define SELECT 309
#define SWITCH 310
#define CASE 311
#define OTHERWISE 312
#define FUNCTION 313
#define ENDFUNCTION 314
#define FOR 315
#define WHILE 316
#define DO 317
#define BREAK 318
#define CONTINUE 319
#define TRY 320
#define CATCH 321
#define RETURN 322
#define FLEX_ERROR 323
#define STR 324
#define ID 325
#define VARINT 326
#define VARFLOAT 327
#define NUM 328
#define PATH 329
#define COMMENT 330
#define BLOCKCOMMENT 331
#define TOPLEVEL 332
#define HIGHLEVEL 333
#define UPLEVEL 334
#define LISTABLE 335
#define CONTROLBREAK 336
#define UMINUS 337
#define UPLUS 338
#define FUNCTIONCALL 339

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
union YYSTYPE
{

  /* Tokens. */
    double                      number;
    std::wstring*               str;
    std::wstring*               path;
    std::wstring*               comment;

    LineBreakStr*               mute;

    ast::exps_t*                t_list_var;
    ast::exps_t*                t_list_exp;
    ast::Exp*                   t_exp;

    ast::SeqExp*                t_seq_exp;
    ast::ReturnExp*             t_return_exp;

    ast::IfExp*                 t_if_exp;
    ast::WhileExp*              t_while_exp;
    ast::ForExp*                t_for_exp;
    ast::TryCatchExp*           t_try_exp;
    ast::SelectExp*             t_select_exp;
    ast::CaseExp*               t_case_exp;
    ast::exps_t*                t_list_case;

    ast::CallExp*               t_call_exp;

    ast::MathExp*               t_math_exp;

    ast::OpExp*                 t_op_exp;
    ast::OpExp::Oper            t_op_exp_oper;
    ast::LogicalOpExp::Oper     t_lop_exp_oper;

    ast::AssignExp*             t_assign_exp;

    ast::StringExp*             t_string_exp;

    ast::ListExp*               t_implicit_list;

    ast::MatrixExp*             t_matrix_exp;
    ast::MatrixLineExp*         t_matrixline_exp;
    ast::exps_t*                t_list_mline;

    ast::CellExp*               t_cell_exp;

    ast::CellCallExp*           t_cell_call_exp;

    ast::FunctionDec*           t_function_dec;

    ast::ArrayListExp*          t_arraylist_exp;
    ast::AssignListExp*         t_assignlist_exp;
    ast::ArrayListVar*          t_arraylist_var;

    ast::SimpleVar*             t_simple_var;


};
typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif

/* Location type.  */
#if ! defined YYLTYPE && ! defined YYLTYPE_IS_DECLARED
typedef struct YYLTYPE YYLTYPE;
struct YYLTYPE
{
  int first_line;
  int first_column;
  int last_line;
  int last_column;
};
# define YYLTYPE_IS_DECLARED 1
# define YYLTYPE_IS_TRIVIAL 1
#endif


extern YYSTYPE yylval;
extern YYLTYPE yylloc;

int yyparse (void);


#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
