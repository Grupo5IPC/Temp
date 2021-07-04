package com.grupo5;

public class Handler {
    public static Log log;
    public static String cadena = "";

    public Handler(Log log2) {
        log = log2;

    }


    public boolean ComprobarFila_Alumno(String fila[], int cont2, int linea) {
        boolean state = true;
        int cont = 0;
        if (cont2 == 0) {
            log.add_Titulo("\t Carga de Alumnos  ");

        }
        if (fila.length == 5) {

            try {
                //System.out.println("ID: "+ fila[0]);

                if (verficarEntero(fila[0].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el ID \"" + fila[0] + " \" ");
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el Carnet \"" + fila[1] + " \" ");
                    cont++;
                }
                if (verificarChar(fila[4]) == false) {
                    log.addCuerpo("Linea " + linea + ": El genero ingresado debe ser \"M\" o \"F\": " + fila[4] + "");
                    cont++;
                }
                if (cont > 0) {

                    state = false;
                }


            } catch (Exception e) {
                log.addCuerpo("El alumno con ID " + fila[0] + " no puede ser ingresado, verifique que todos los campos sean correctos");
                state = false;
            }
        } else {

            state = false;
        }
        //System.out.println(state);

        return state;
    }

    public boolean ComprobarFilaprofesor(String fila[], int cont2, int linea) {
        boolean state = true;
        int cont = 0;
        if (cont2 == 0) {
            log.add_Titulo("\t Carga de Profesores  ");

        }
        if (fila.length == 6) {

            try {
                //System.out.println("ID: "+ fila[0]);

                if (verficarEntero(fila[0].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el ID \"" + fila[0] + " \" ");
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el Registro \"" + fila[1] + " \" ");
                    cont++;
                }
                if (verificarChar(fila[6]) == false) {
                    log.addCuerpo("Linea " + linea + ": El genero ingresado debe ser \"M\" o \"F\": " + fila[6] + "");
                    cont++;
                }
                if (cont > 0) {

                    state = false;
                }


            } catch (Exception e) {
                log.addCuerpo("El profesor con ID " + fila[0] + " no puede ser ingresado, verifique que todos los campos sean correctos");
                state = false;
            }
        } else {

            state = false;
        }
        //System.out.println(state);

        return state;
    }

    public boolean ComprobarFila_curso(String fila[], int cont2, int linea) {
        boolean state = true;
        int cont = 0;
        if (cont2 == 0) {
            log.add_Titulo("\t Carga de Cursos  ");

        }
        if (fila.length == 3) {
            try {
                if (verficarEntero(fila[0].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el ID \"" + fila[0] + " \" ");
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el Codigo \"" + fila[0] + " \" ");
                    cont++;
                }

                if (cont > 0) {
                    state = false;
                }


            } catch (Exception e) {
                state = false;
            }
        } else {
            log.addCuerpo("El curso con ID " + fila[0] + " no puede ser ingresado, verifique que todos los campos sean correctos");
            state = false;
        }
        //System.out.println(state);

        return state;
    }

    public boolean ComprobarFila_asignacion(String fila[], int modo, int cont2, int linea) {
        boolean state = true;
        int cont = 0;
        String nombre;
        if (modo == 1) {
            nombre = "Alumnos";
        } else {
            nombre = "Profesores";
        }
        if (cont2 == 0) {

            log.add_Titulo("\t Asignacion de " + nombre + "  ");
        }
        if (fila.length == 2) {
            try {
                if (verficarEntero(fila[0].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el ID \"" + fila[0] + " \" ");
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el ID \"" + fila[1] + " \" ");
                    cont++;
                }

                if (cont > 0) {
                    state = false;
                }


            } catch (Exception e) {
                state = false;
            }
        } else {
            log.addCuerpo("La asignacion en la linea " + linea + " no se puedo efectuar, verifique que todos los campos sean correctos");
            state = false;
        }
        //System.out.println(state);

        return state;
    }

    public boolean ComprobarFila_notas(String fila[], int cont2, int linea) {
        boolean state = true;
        int cont = 0;
        if (cont2 == 0) {

            log.add_Titulo("\t Asignacion de  notas ");
        }
        if (fila.length == 3) {
            try {
                if (verficarEntero(fila[0].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el ID \"" + fila[0] + " \" ");
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el ID \"" + fila[1] + " \" ");
                    cont++;
                }
                if (verficarDecimal(fila[2].toString()) != true) {
                    log.addCuerpo("Linea " + linea + ": Error al convertir el numero \"" + fila[2] + " \" ");
                    cont++;
                }

                if (cont > 0) {
                    state = false;
                }


            } catch (Exception e) {
                state = false;
            }
        } else {
            log.addCuerpo("La asignacion de notas en la linea " + linea + " no se puedo efectuar, verifique que todos los campos sean correctos");
            state = false;
        }
        //System.out.println(state);

        return state;
    }


    private boolean verficarEntero(String parse) {
        try {

            Integer.parseInt(parse);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    private boolean verficarDecimal(String parse) {
        try {

            Double.parseDouble(parse);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    private boolean verificarChar(String parse) {
        boolean state = false;
        try {
            char genero = Character.toUpperCase(parse.charAt(0));

            if (genero == 'M') {
                state = true;
            } else if (genero == 'F') {
                state = true;
            }
        } catch (Exception e) {
            state = false;
        }
        return state;
    }
}