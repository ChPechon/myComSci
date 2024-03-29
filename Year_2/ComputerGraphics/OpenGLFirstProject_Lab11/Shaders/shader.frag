#version 330

in vec4 vCol;
out vec4 colour;
in vec2 TexCoord;

uniform vec3 lightColour;
uniform sampler2D texture2D;

void main()
{
    float ambientStrength = 0.3f;
    vec3 ambient = ambientStrength * lightColour;
    colour = texture(texture2D, TexCoord) * vec4(ambient, 1.0);
}