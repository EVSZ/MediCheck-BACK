package medicheck.backend.APIs.RequestModels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter @Setter
public class AccessData
{
        private long userID;

        private String userKey;

        public AccessData(){

        }



}
