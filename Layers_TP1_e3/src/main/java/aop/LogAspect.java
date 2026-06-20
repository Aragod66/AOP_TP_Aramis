package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
public class LogAspect {

    private static final String ARCHIVO_LOG = "logs.txt";

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Around("execution(@aop.Log * *(..))")
    public Object loguearInvocacion(ProceedingJoinPoint joinPoint) throws Throwable {

        String nombreMetodo = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();

        String parametros = args.length == 0
                ? "sin parametros"
                : Arrays.stream(args)
                .map(String::valueOf)
                .collect(Collectors.joining("|"));

        String fechaHora = LocalDateTime.now().format(FORMATO_FECHA);

        escribirLog(nombreMetodo, parametros, fechaHora);

        return joinPoint.proceed();
    }

    private void escribirLog(String metodo, String parametros, String fechaHora) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(ARCHIVO_LOG, true))) {

            writer.write(
                    "\"" + metodo + "\", " +
                            "\"" + parametros + "\", " +
                            "\"" + fechaHora + "\""
            );

            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}