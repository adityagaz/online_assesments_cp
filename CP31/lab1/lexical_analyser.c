#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
// importing the required header files
#define MAX_TOKENS 100
#define MAX_TOKEN_LENGTH 50
#define NUM_KEYWORDS 32

//here we are defining the different arrays for storing identfiers , operators ...

char identifiers[MAX_TOKENS][MAX_TOKEN_LENGTH];
char operators[MAX_TOKENS][MAX_TOKEN_LENGTH];
char keywords_found[MAX_TOKENS][MAX_TOKEN_LENGTH];
char constants[MAX_TOKENS][MAX_TOKEN_LENGTH];
char separators[MAX_TOKENS][MAX_TOKEN_LENGTH];
int id_count = 0, op_count = 0, kw_count = 0, const_count = 0, sep_count = 0;

const char *keywords[] = {
    "auto", "break", "case", "char", "const", "continue", "default", "do",
    "double", "else", "enum", "extern", "float", "for", "goto", "if",
    "inline", "int", "long", "register", "restrict", "return", "short",
    "signed", "sizeof", "static", "struct", "switch", "typedef", "union",
    "unsigned", "void", "volatile", "while"
};
//above are all the identifiers in C language
int is_keyword(const char *tok) {
    for (int i = 0; i < NUM_KEYWORDS; i++) {
        if (strcmp(tok, keywords[i]) == 0) {
            return 1;
        }
    }
    return 0;
}
//function to check if any char matches our keyword then no further processing required
int is_operator(char ch) {
    if (strchr("+-*/=<>&|!^~?:", ch)!=  NULL ) {
        return 1;
    }
    return 0;
}
//function check for operators
int is_separator(char ch) {
    if (strchr(";,(){}[]", ch)!= NULL) {
        return 1;
    }
    return 0;
}

int is_constant(const char *tok) {
    if (isdigit(tok[0])) return 1;
    if ((tok[0] == '"' && tok[strlen(tok)-1] == '"') ||
        (tok[0] == '\'' && tok[strlen(tok)-1] == '\''))
    {
        return 1;
    }
    return 0;
}
//constants
void process_token(const char *tok) {
    if (is_keyword(tok)) {
        strcpy(keywords_found[kw_count++], tok);
    } else if (is_constant(tok)) {
        strcpy(constants[const_count++], tok);
    } else if (isalpha(tok[0]) || tok[0] == '_') {
        strcpy(identifiers[id_count++], tok);
    }
}
void tokenize_line(const char *line) {
    char buffer[MAX_TOKEN_LENGTH];
    int idx = 0;
    for (int i = 0; line[i] != '\0'; i++) {
        char ch = line[i];
        if (isalnum(ch) || ch == '_') {
            buffer[idx++] = ch;
        } else {
            if (idx > 0) {
                        buffer[idx] = '\0';
                        process_token(buffer);
                        idx = 0;
            }
            if (is_operator(ch)) {
                        char op_buf[2];
                        op_buf[0] = ch;
                        op_buf[1] = '\0';
                        strcpy(operators[op_count++], op_buf);
            } else if (is_separator(ch)) {
                        char sep_buf[2];
                        sep_buf[0] = ch;
                        sep_buf[1] = '\0';
                        strcpy(separators[sep_count++], sep_buf);
            }
        }
    }
    if (idx > 0) {
        buffer[idx] = '\0';
        process_token(buffer);
    }
}
int main() {
    char filename[100];
    FILE *f;
    char line[512];

    printf("Enter the file name ");
    scanf("%s", filename);

    f = fopen(filename, "r");
    if (f == NULL) {
        printf("Could not open file.\n");
        return 1;
    }

    while (fgets(line, sizeof(line), f)) {
        tokenize_line(line);
    }

    fclose(f);

    printf("\nKeywords Found:  \n");
    for (int i = 0; i < kw_count; i++) {
        printf("%s ", keywords_found[i]);
    }
    printf("\n\nIdentifiers : \n");
    for (int i = 0; i < id_count; i++) {
        printf("%s ", identifiers[i]);
    }
    printf("\n\nOperators :\n");
    for (int i = 0; i < op_count; i++) {
        printf("%s ", operators[i]);
    }
    printf("\n\nConstants :\n");
    for (int i = 0; i < const_count; i++) {
        printf("%s ", constants[i]);
    }
    printf("\n\nSeparators are :  \n");
    for (int i = 0; i < sep_count; i++) {
        printf("%s ", separators[i]);
    }
    printf("\n");
    return 0;
}
