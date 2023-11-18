#include <stdio.h> 
#include <string.h> 
#include <time.h>

struct persona{
    char nombre[50]; 
    int dbd;
    int mbd;
    int ybd;
};

typedef struct persona Persona;

//Prototipo de funciones
//struct persona getInformation();
struct persona getInformation() {
  struct persona Axel;

  printf("Cual es tu nombre?\n");
  scanf ("%s", &Axel.nombre);
  printf("En que da naciste?\n");   
  scanf("%d", &Axel.dbd);   
  printf("En que mes naciste?\n");    
  scanf("%d", &Axel.mbd);  
  printf("En que anio naciste?\n");    
  scanf("%d", &Axel.ybd);   
  return Axel;
}	

int* calculos(Persona miPersona, int fechaEntrada[]){
	static int fechaSalida[3];
	//La entrada 0 son los días, la entrada 1 son los meses y la entrada 2 son los años
	fechaSalida[2]=fechaEntrada[2] - miPersona.ybd;
	fechaSalida[1]= fechaEntrada[1] - miPersona.mbd;
	if (fechaEntrada[1] == miPersona.mbd) {
        fechaSalida[2] = fechaSalida[2] -1;
		fechaSalida[1] = 11;
	} else if (fechaEntrada[1] < miPersona.mbd){
		fechaSalida[1] = fechaSalida[1] +12;
        fechaSalida[2] = fechaSalida[2]-1;
	}
    if(fechaEntrada[0]<miPersona.dbd){
        fechaSalida[1]--;
    }

	fechaSalida[0]= fechaEntrada[0] - miPersona.dbd;
	if (fechaEntrada[0] < miPersona.dbd){
		if (miPersona.mbd == 1||3||5||7||8||10||12){
			fechaSalida[0] = fechaSalida[0] +30;
		} else if (miPersona.mbd == 4||6||9||11){
			fechaSalida[0] = fechaSalida[0] +31;
		} else if (miPersona.mbd == 2){
			if (miPersona.ybd%4 && miPersona.ybd%10 && miPersona.ybd%400){
			fechaSalida[0] = fechaSalida[0] +29;
			} else {
				fechaSalida[0] = fechaSalida[0] +28;
			}
		}
	}
	return fechaSalida;
}
void menu(int fechaHoy[]){
	struct persona s;
    s = getInformation();
    int *diasAntes;
    int sel;
    int fechaIntro[3];
    printf("Quieres que se calcule con (1) la fecha de hoy o (2) otra fecha?\n");
    scanf("%d", &sel);
	if (sel == 2){
		printf("Escribe el dia:\n");   
		scanf("%d", &fechaIntro[0]);   
		printf("Escribe el mes:\n");    
		scanf("%d", &fechaIntro[1]);  
		printf("Escribe el anio:\n");    
		scanf("%d", &fechaIntro[2]); 
	}   else if(sel == 1){
		fechaIntro[0] = fechaHoy[0];
		fechaIntro[1] = fechaHoy[1];
		fechaIntro[2] = fechaHoy[2];
	} else{
		printf("Elige una opcion valida\n\n");
	}
    if (sel == 1|| sel == 2){
		diasAntes = calculos(s,fechaIntro);
        printf("%s, tu edad es de %d anios, %d meses y %d dias\n\n",s.nombre,diasAntes[2],diasAntes[1],diasAntes[0]);
    }
	}
int main(){
    int fechaHoy[] = {17, 11, 2023};
    menu(fechaHoy);
    return 0;
}