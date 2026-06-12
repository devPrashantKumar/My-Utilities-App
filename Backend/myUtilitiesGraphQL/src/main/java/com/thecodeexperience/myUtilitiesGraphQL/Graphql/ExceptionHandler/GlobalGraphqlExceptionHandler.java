package com.thecodeexperience.myUtilitiesGraphQL.Graphql.ExceptionHandler;


import com.thecodeexperience.myUtilitiesGraphQL.Dtos.ErrorResponseDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Exception.GenericStatusException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GlobalGraphqlExceptionHandler extends DataFetcherExceptionResolverAdapter {

    public static final String GENERIC_EXCEPTION = "GENERIC_EXCEPTION";
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    public static final String CODE = "code";
    public static final String ERROR_RESPONSE = "errorResponse";
    public static final String EXCEPTION = "exception";

    @Override
    protected GraphQLError resolveToSingleError(
            Throwable ex,
            DataFetchingEnvironment env) {

        if (ex instanceof GenericStatusException) {
            return GraphqlErrorBuilder.newError(env)
                    .message(ex.getMessage())
                    .extensions(Map.of(
                            CODE, ((GenericStatusException) ex).getStatus(),
                            EXCEPTION, GENERIC_EXCEPTION,
                            ERROR_RESPONSE, new ErrorResponseDTO(ex.getMessage(), ((GenericStatusException) ex).getStatus())
                    )).build();
        }

        return GraphqlErrorBuilder.newError(env)
                .message(ex.getMessage())
                .extensions(Map.of(
                        CODE, 500,
                        EXCEPTION, INTERNAL_SERVER_ERROR,
                        ERROR_RESPONSE, new ErrorResponseDTO(ex.getMessage(), 500)
                )).build();
    }
}